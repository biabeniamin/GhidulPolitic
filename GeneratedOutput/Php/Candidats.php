<?php
header('Access-Control-Allow-Origin: *'); 
header('Access-Control-Allow-Headers: *'); 
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS');
$_POST = json_decode(file_get_contents('php://input'), true);
require_once 'Models/Candidat.php';
require_once 'DatabaseOperations.php';
require_once 'Helpers.php';
function ConvertListToCandidats($data)
{
	$candidats = [];
	
	foreach($data as $row)
	{
		$candidat = new Candidat(
		$row["Nume"], 
		$row["Descriere"], 
		$row["Functie"] 
		);
	
		$candidat->SetCandidatId($row["CandidatId"]);
		$candidat->SetCreationTime($row["CreationTime"]);
	
		$candidats[count($candidats)] = $candidat;
	}
	
	return $candidats;
}

function GetCandidats($database)
{
	$data = $database->ReadData("SELECT * FROM Candidats");
	$candidats = ConvertListToCandidats($data);
	return $candidats;
}

function GetCandidatsByCandidatId($database, $candidatId)
{
	$data = $database->ReadData("SELECT * FROM Candidats WHERE CandidatId = $candidatId");
	$candidats = ConvertListToCandidats($data);
	if(0== count($candidats))
	{
		return [GetEmptyCandidat()];
	}
	return $candidats;
}

function CompleteCandidats($database, $candidats)
{
	$candidats = GetCandidats($database);
	foreach($candidats as $candidat)
	{
		$start = 0;
		$end = count($candidats) - 1;
		do
		{
	
			$mid = floor(($start + $end) / 2);
			if($candidat->GetCandidatId() > $candidats[$mid]->GetCandidatId())
			{
				$start = $mid + 1;
			}
			else if($candidat->GetCandidatId() < $candidats[$mid]->GetCandidatId())
			{
				$end = $mid - 1;
			}
			else if($candidat->GetCandidatId() == $candidats[$mid]->GetCandidatId())
			{
				$start = $mid + 1;
				$end = $mid - 1;
				$candidat->SetCandidat($candidats[$mid]);
			}
	
		}while($start <= $end);
	}
	
	return $candidats;
}

function AddCandidat($database, $candidat)
{
	$query = "INSERT INTO Candidats(Nume, Descriere, Functie, CreationTime) VALUES(";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$candidat->GetNume()) . "', ";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$candidat->GetDescriere()) . "', ";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$candidat->GetFunctie()) . "', ";
	$query = $query . "NOW()"."";
	
	$query = $query . ");";
	$database->ExecuteSqlWithoutWarning($query);
	$id = $database->GetLastInsertedId();
	$candidat->SetCandidatId($id);
	$candidat->SetCreationTime(date('Y-m-d H:i:s'));
	return $candidat;
	
}

function DeleteCandidat($database, $candidatId)
{
	$candidat = GetCandidatsByCandidatId($database, $candidatId)[0];
	
	$query = "DELETE FROM Candidats WHERE CandidatId=$candidatId";
	
	$result = $database->ExecuteSqlWithoutWarning($query);
	
	if(0 != $result)
	{
		$candidat->SetCandidatId(0);
	}
	
	return $candidat;
	
}

function UpdateCandidat($database, $candidat)
{
	$query = "UPDATE Candidats SET ";
	$query = $query . "Nume='" . $candidat->GetNume() . "', ";
	$query = $query . "Descriere='" . $candidat->GetDescriere() . "', ";
	$query = $query . "Functie='" . $candidat->GetFunctie() . "'";
	$query = $query . " WHERE CandidatId=" . $candidat->GetCandidatId();
	
	$result = $database->ExecuteSqlWithoutWarning($query);
	if(0 == $result)
	{
		$candidat->SetCandidatId(0);
	}
	return $candidat;
	
}

function TestAddCandidat($database)
{
	$candidat = new Candidat(
		'Test',//Nume
		'Test',//Descriere
		'Test'//Functie
	);
	
	AddCandidat($database, $candidat);
}

function GetEmptyCandidat()
{
	$candidat = new Candidat(
		'',//Nume
		'',//Descriere
		''//Functie
	);
	
	return $candidat;
}

if(CheckGetParameters(["cmd"]))
{
	if("getCandidats" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
			echo json_encode(GetCandidats($database));
	}

	if("getLastCandidat" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
			echo json_encode(GetLastCandidat($database));
	}

	else if("getCandidatsByCandidatId" == $_GET["cmd"])
	{
		if(CheckGetParameters([
			'candidatId'
			]))
		{
			$database = new DatabaseOperations();
			echo json_encode(GetCandidatsByCandidatId($database, 
				$_GET["candidatId"]
			));
		}
	
	}

	else if("addCandidat" == $_GET["cmd"])
	{
		if(CheckGetParameters([
			'nume',
			'descriere',
			'functie'
		]))
		{
			$database = new DatabaseOperations();
			$candidat = new Candidat(
				$_GET['nume'],
				$_GET['descriere'],
				$_GET['functie']
			);
		
			echo json_encode(AddCandidat($database, $candidat));
		}
	
	}

}

if(CheckGetParameters(["cmd"]))
{
	if("addCandidat" == $_GET["cmd"])
	{
		if(CheckPostParameters([
			'nume',
			'descriere',
			'functie'
		]))
		{
			$database = new DatabaseOperations();
			$candidat = new Candidat(
				$_POST['nume'],
				$_POST['descriere'],
				$_POST['functie']
			);
	
			echo json_encode(AddCandidat($database, $candidat));
		}

	}
}

if(CheckGetParameters(["cmd"]))
{
	if("updateCandidat" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
		$candidat = new Candidat(
			$_POST['nume'],
			$_POST['descriere'],
			$_POST['functie']
		);
		$candidat->SetCandidatId($_POST['candidatId']);
		$candidat->SetCreationTime($_POST['creationTime']);
		
		$candidat = UpdateCandidat($database, $candidat);
		echo json_encode($candidat);

	}
}

if("DELETE" == $_SERVER['REQUEST_METHOD']
	&& CheckGetParameters(["cmd"]))
{
	if("deleteCandidat" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
		$candidatId = $_GET['candidatId'];
		
		$candidat = DeleteCandidat($database, $candidatId);
		echo json_encode($candidat);

	}
}


function GetLastCandidat($database)
{
	$data = $database->ReadData("SELECT * FROM Candidats ORDER BY CreationTime DESC LIMIT 1");
	$candidats = ConvertListToCandidats($data);
	return $candidats;
}

?>
