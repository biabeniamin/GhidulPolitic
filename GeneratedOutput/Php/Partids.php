<?php
header('Access-Control-Allow-Origin: *'); 
header('Access-Control-Allow-Headers: *'); 
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS');
$_POST = json_decode(file_get_contents('php://input'), true);
require_once 'Models/Partid.php';
require_once 'DatabaseOperations.php';
require_once 'Helpers.php';
function ConvertListToPartids($data)
{
	$partids = [];
	
	foreach($data as $row)
	{
		$partid = new Partid(
		$row["Nume"], 
		$row["Pozitie"] 
		);
	
		$partid->SetPartidId($row["PartidId"]);
		$partid->SetCreationTime($row["CreationTime"]);
	
		$partids[count($partids)] = $partid;
	}
	
	return $partids;
}

function GetPartids($database)
{
	$data = $database->ReadData("SELECT * FROM Partids");
	$partids = ConvertListToPartids($data);
	return $partids;
}

function GetPartidsByPartidId($database, $partidId)
{
	$data = $database->ReadData("SELECT * FROM Partids WHERE PartidId = $partidId");
	$partids = ConvertListToPartids($data);
	if(0== count($partids))
	{
		return [GetEmptyPartid()];
	}
	return $partids;
}

function CompletePartids($database, $partids)
{
	$partids = GetPartids($database);
	foreach($partids as $partid)
	{
		$start = 0;
		$end = count($partids) - 1;
		do
		{
	
			$mid = floor(($start + $end) / 2);
			if($partid->GetPartidId() > $partids[$mid]->GetPartidId())
			{
				$start = $mid + 1;
			}
			else if($partid->GetPartidId() < $partids[$mid]->GetPartidId())
			{
				$end = $mid - 1;
			}
			else if($partid->GetPartidId() == $partids[$mid]->GetPartidId())
			{
				$start = $mid + 1;
				$end = $mid - 1;
				$partid->SetPartid($partids[$mid]);
			}
	
		}while($start <= $end);
	}
	
	return $partids;
}

function AddPartid($database, $partid)
{
	$query = "INSERT INTO Partids(Nume, Pozitie, CreationTime) VALUES(";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$partid->GetNume()) . "', ";
	$query = $query . mysqli_real_escape_string($database->connection ,$partid->GetPozitie()).", ";
	$query = $query . "NOW()"."";
	
	$query = $query . ");";
	$database->ExecuteSqlWithoutWarning($query);
	$id = $database->GetLastInsertedId();
	$partid->SetPartidId($id);
	$partid->SetCreationTime(date('Y-m-d H:i:s'));
	return $partid;
	
}

function DeletePartid($database, $partidId)
{
	$partid = GetPartidsByPartidId($database, $partidId)[0];
	
	$query = "DELETE FROM Partids WHERE PartidId=$partidId";
	
	$result = $database->ExecuteSqlWithoutWarning($query);
	
	if(0 != $result)
	{
		$partid->SetPartidId(0);
	}
	
	return $partid;
	
}

function UpdatePartid($database, $partid)
{
	$query = "UPDATE Partids SET ";
	$query = $query . "Nume='" . $partid->GetNume() . "', ";
	$query = $query . "Pozitie=" . $partid->GetPozitie()."";
	$query = $query . " WHERE PartidId=" . $partid->GetPartidId();
	
	$result = $database->ExecuteSqlWithoutWarning($query);
	if(0 == $result)
	{
		$partid->SetPartidId(0);
	}
	return $partid;
	
}

function TestAddPartid($database)
{
	$partid = new Partid(
		'Test',//Nume
		0//Pozitie
	);
	
	AddPartid($database, $partid);
}

function GetEmptyPartid()
{
	$partid = new Partid(
		'',//Nume
		0//Pozitie
	);
	
	return $partid;
}

if(CheckGetParameters(["cmd"]))
{
	if("getPartids" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
			echo json_encode(GetPartids($database));
	}

	if("getLastPartid" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
			echo json_encode(GetLastPartid($database));
	}

	else if("getPartidsByPartidId" == $_GET["cmd"])
	{
		if(CheckGetParameters([
			'partidId'
			]))
		{
			$database = new DatabaseOperations();
			echo json_encode(GetPartidsByPartidId($database, 
				$_GET["partidId"]
			));
		}
	
	}

	else if("addPartid" == $_GET["cmd"])
	{
		if(CheckGetParameters([
			'nume',
			'pozitie'
		]))
		{
			$database = new DatabaseOperations();
			$partid = new Partid(
				$_GET['nume'],
				$_GET['pozitie']
			);
		
			echo json_encode(AddPartid($database, $partid));
		}
	
	}

}

if(CheckGetParameters(["cmd"]))
{
	if("addPartid" == $_GET["cmd"])
	{
		if(CheckPostParameters([
			'nume',
			'pozitie'
		]))
		{
			$database = new DatabaseOperations();
			$partid = new Partid(
				$_POST['nume'],
				$_POST['pozitie']
			);
	
			echo json_encode(AddPartid($database, $partid));
		}

	}
}

if(CheckGetParameters(["cmd"]))
{
	if("updatePartid" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
		$partid = new Partid(
			$_POST['nume'],
			$_POST['pozitie']
		);
		$partid->SetPartidId($_POST['partidId']);
		$partid->SetCreationTime($_POST['creationTime']);
		
		$partid = UpdatePartid($database, $partid);
		echo json_encode($partid);

	}
}

if("DELETE" == $_SERVER['REQUEST_METHOD']
	&& CheckGetParameters(["cmd"]))
{
	if("deletePartid" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
		$partidId = $_GET['partidId'];
		
		$partid = DeletePartid($database, $partidId);
		echo json_encode($partid);

	}
}


function GetLastPartid($database)
{
	$data = $database->ReadData("SELECT * FROM Partids ORDER BY CreationTime DESC LIMIT 1");
	$partids = ConvertListToPartids($data);
	return $partids;
}

?>
