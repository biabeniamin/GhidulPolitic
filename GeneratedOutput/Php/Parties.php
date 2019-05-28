<?php
header('Access-Control-Allow-Origin: *'); 
header('Access-Control-Allow-Headers: *'); 
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS');
$_POST = json_decode(file_get_contents('php://input'), true);
require_once 'Models/Partie.php';
require_once 'DatabaseOperations.php';
require_once 'Helpers.php';
function ConvertListToParties($data)
{
	$parties = [];
	
	foreach($data as $row)
	{
		$partie = new Partie(
		$row["Name"], 
		$row["Position"] 
		);
	
		$partie->SetPartieId($row["PartieId"]);
		$partie->SetCreationTime($row["CreationTime"]);
	
		$parties[count($parties)] = $partie;
	}
	
	return $parties;
}

function GetParties($database)
{
	$data = $database->ReadData("SELECT * FROM Parties");
	$parties = ConvertListToParties($data);
	return $parties;
}

function GetPartiesByPartieId($database, $partieId)
{
	$data = $database->ReadData("SELECT * FROM Parties WHERE PartieId = $partieId");
	$parties = ConvertListToParties($data);
	if(0== count($parties))
	{
		return [GetEmptyPartie()];
	}
	return $parties;
}

function CompleteParties($database, $parties)
{
	$parties = GetParties($database);
	foreach($parties as $partie)
	{
		$start = 0;
		$end = count($parties) - 1;
		do
		{
	
			$mid = floor(($start + $end) / 2);
			if($partie->GetPartieId() > $parties[$mid]->GetPartieId())
			{
				$start = $mid + 1;
			}
			else if($partie->GetPartieId() < $parties[$mid]->GetPartieId())
			{
				$end = $mid - 1;
			}
			else if($partie->GetPartieId() == $parties[$mid]->GetPartieId())
			{
				$start = $mid + 1;
				$end = $mid - 1;
				$partie->SetPartie($parties[$mid]);
			}
	
		}while($start <= $end);
	}
	
	return $parties;
}

function AddPartie($database, $partie)
{
	$query = "INSERT INTO Parties(Name, Position, CreationTime) VALUES(";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$partie->GetName()) . "', ";
	$query = $query . mysqli_real_escape_string($database->connection ,$partie->GetPosition()).", ";
	$query = $query . "NOW()"."";
	
	$query = $query . ");";
	$database->ExecuteSqlWithoutWarning($query);
	$id = $database->GetLastInsertedId();
	$partie->SetPartieId($id);
	$partie->SetCreationTime(date('Y-m-d H:i:s'));
	return $partie;
	
}

function DeletePartie($database, $partieId)
{
	$partie = GetPartiesByPartieId($database, $partieId)[0];
	
	$query = "DELETE FROM Parties WHERE PartieId=$partieId";
	
	$result = $database->ExecuteSqlWithoutWarning($query);
	
	if(0 != $result)
	{
		$partie->SetPartieId(0);
	}
	
	return $partie;
	
}

function UpdatePartie($database, $partie)
{
	$query = "UPDATE Parties SET ";
	$query = $query . "Name='" . $partie->GetName() . "', ";
	$query = $query . "Position=" . $partie->GetPosition()."";
	$query = $query . " WHERE PartieId=" . $partie->GetPartieId();
	
	$result = $database->ExecuteSqlWithoutWarning($query);
	if(0 == $result)
	{
		$partie->SetPartieId(0);
	}
	return $partie;
	
}

function TestAddPartie($database)
{
	$partie = new Partie(
		'Test',//Name
		0//Position
	);
	
	AddPartie($database, $partie);
}

function GetEmptyPartie()
{
	$partie = new Partie(
		'',//Name
		0//Position
	);
	
	return $partie;
}

if(CheckGetParameters(["cmd"]))
{
	if("getParties" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
			echo json_encode(GetParties($database));
	}

	if("getLastPartie" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
			echo json_encode(GetLastPartie($database));
	}

	else if("getPartiesByPartieId" == $_GET["cmd"])
	{
		if(CheckGetParameters([
			'partieId'
			]))
		{
			$database = new DatabaseOperations();
			echo json_encode(GetPartiesByPartieId($database, 
				$_GET["partieId"]
			));
		}
	
	}

	else if("addPartie" == $_GET["cmd"])
	{
		if(CheckGetParameters([
			'name',
			'position'
		]))
		{
			$database = new DatabaseOperations();
			$partie = new Partie(
				$_GET['name'],
				$_GET['position']
			);
		
			echo json_encode(AddPartie($database, $partie));
		}
	
	}

}

if(CheckGetParameters(["cmd"]))
{
	if("addPartie" == $_GET["cmd"])
	{
		if(CheckPostParameters([
			'name',
			'position'
		]))
		{
			$database = new DatabaseOperations();
			$partie = new Partie(
				$_POST['name'],
				$_POST['position']
			);
	
			echo json_encode(AddPartie($database, $partie));
		}

	}
}

if(CheckGetParameters(["cmd"]))
{
	if("updatePartie" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
		$partie = new Partie(
			$_POST['name'],
			$_POST['position']
		);
		$partie->SetPartieId($_POST['partieId']);
		$partie->SetCreationTime($_POST['creationTime']);
		
		$partie = UpdatePartie($database, $partie);
		echo json_encode($partie);

	}
}

if("DELETE" == $_SERVER['REQUEST_METHOD']
	&& CheckGetParameters(["cmd"]))
{
	if("deletePartie" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
		$partieId = $_GET['partieId'];
		
		$partie = DeletePartie($database, $partieId);
		echo json_encode($partie);

	}
}


function GetLastPartie($database)
{
	$data = $database->ReadData("SELECT * FROM Parties ORDER BY CreationTime DESC LIMIT 1");
	$parties = ConvertListToParties($data);
	return $parties;
}

?>
