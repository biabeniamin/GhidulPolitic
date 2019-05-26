<?php
header('Access-Control-Allow-Origin: *'); 
header('Access-Control-Allow-Headers: *'); 
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS');
$_POST = json_decode(file_get_contents('php://input'), true);
require_once 'Models/Candidate.php';
require_once 'DatabaseOperations.php';
require_once 'Helpers.php';
function ConvertListToCandidates($data)
{
	$candidates = [];
	
	foreach($data as $row)
	{
		$candidate = new Candidate(
		$row["Name"], 
		$row["Email"], 
		$row["Password"], 
		$row["Description"], 
		$row["Role"] 
		);
	
		$candidate->SetCandidateId($row["CandidateId"]);
		$candidate->SetCreationTime($row["CreationTime"]);
	
		$candidates[count($candidates)] = $candidate;
	}
	
	return $candidates;
}

function GetCandidates($database)
{
	$data = $database->ReadData("SELECT * FROM Candidates");
	$candidates = ConvertListToCandidates($data);
	return $candidates;
}

function GetCandidatesByCandidateId($database, $candidateId)
{
	$data = $database->ReadData("SELECT * FROM Candidates WHERE CandidateId = $candidateId");
	$candidates = ConvertListToCandidates($data);
	if(0== count($candidates))
	{
		return [GetEmptyCandidate()];
	}
	return $candidates;
}

function CompleteCandidates($database, $candidates)
{
	$candidates = GetCandidates($database);
	foreach($candidates as $candidate)
	{
		$start = 0;
		$end = count($candidates) - 1;
		do
		{
	
			$mid = floor(($start + $end) / 2);
			if($candidate->GetCandidateId() > $candidates[$mid]->GetCandidateId())
			{
				$start = $mid + 1;
			}
			else if($candidate->GetCandidateId() < $candidates[$mid]->GetCandidateId())
			{
				$end = $mid - 1;
			}
			else if($candidate->GetCandidateId() == $candidates[$mid]->GetCandidateId())
			{
				$start = $mid + 1;
				$end = $mid - 1;
				$candidate->SetCandidate($candidates[$mid]);
			}
	
		}while($start <= $end);
	}
	
	return $candidates;
}

function AddCandidate($database, $candidate)
{
	$query = "INSERT INTO Candidates(Name, Email, Password, Description, Role, CreationTime) VALUES(";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$candidate->GetName()) . "', ";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$candidate->GetEmail()) . "', ";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$candidate->GetPassword()) . "', ";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$candidate->GetDescription()) . "', ";
	$query = $query . "'" . mysqli_real_escape_string($database->connection ,$candidate->GetRole()) . "', ";
	$query = $query . "NOW()"."";
	
	$query = $query . ");";
	$database->ExecuteSqlWithoutWarning($query);
	$id = $database->GetLastInsertedId();
	$candidate->SetCandidateId($id);
	$candidate->SetCreationTime(date('Y-m-d H:i:s'));
	return $candidate;
	
}

function DeleteCandidate($database, $candidateId)
{
	$candidate = GetCandidatesByCandidateId($database, $candidateId)[0];
	
	$query = "DELETE FROM Candidates WHERE CandidateId=$candidateId";
	
	$result = $database->ExecuteSqlWithoutWarning($query);
	
	if(0 != $result)
	{
		$candidate->SetCandidateId(0);
	}
	
	return $candidate;
	
}

function UpdateCandidate($database, $candidate)
{
	$query = "UPDATE Candidates SET ";
	$query = $query . "Name='" . $candidate->GetName() . "', ";
	$query = $query . "Email='" . $candidate->GetEmail() . "', ";
	$query = $query . "Password='" . $candidate->GetPassword() . "', ";
	$query = $query . "Description='" . $candidate->GetDescription() . "', ";
	$query = $query . "Role='" . $candidate->GetRole() . "'";
	$query = $query . " WHERE CandidateId=" . $candidate->GetCandidateId();
	
	$result = $database->ExecuteSqlWithoutWarning($query);
	if(0 == $result)
	{
		$candidate->SetCandidateId(0);
	}
	return $candidate;
	
}

function TestAddCandidate($database)
{
	$candidate = new Candidate(
		'Test',//Name
		'Test',//Email
		'Test',//Password
		'Test',//Description
		'Test'//Role
	);
	
	AddCandidate($database, $candidate);
}

function GetEmptyCandidate()
{
	$candidate = new Candidate(
		'',//Name
		'',//Email
		'',//Password
		'',//Description
		''//Role
	);
	
	return $candidate;
}

if(CheckGetParameters(["cmd"]))
{
	if("getCandidates" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
			echo json_encode(GetCandidates($database));
	}

	if("getLastCandidate" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
			echo json_encode(GetLastCandidate($database));
	}

	else if("getCandidatesByCandidateId" == $_GET["cmd"])
	{
		if(CheckGetParameters([
			'candidateId'
			]))
		{
			$database = new DatabaseOperations();
			echo json_encode(GetCandidatesByCandidateId($database, 
				$_GET["candidateId"]
			));
		}
	
	}

	else if("addCandidate" == $_GET["cmd"])
	{
		if(CheckGetParameters([
			'name',
			'email',
			'password',
			'description',
			'role'
		]))
		{
			$database = new DatabaseOperations();
			$candidate = new Candidate(
				$_GET['name'],
				$_GET['email'],
				$_GET['password'],
				$_GET['description'],
				$_GET['role']
			);
		
			echo json_encode(AddCandidate($database, $candidate));
		}
	
	}

}

if(CheckGetParameters(["cmd"]))
{
	if("addCandidate" == $_GET["cmd"])
	{
		if(CheckPostParameters([
			'name',
			'email',
			'password',
			'description',
			'role'
		]))
		{
			$database = new DatabaseOperations();
			$candidate = new Candidate(
				$_POST['name'],
				$_POST['email'],
				$_POST['password'],
				$_POST['description'],
				$_POST['role']
			);
	
			echo json_encode(AddCandidate($database, $candidate));
		}

	}
}

if(CheckGetParameters(["cmd"]))
{
	if("updateCandidate" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
		$candidate = new Candidate(
			$_POST['name'],
			$_POST['email'],
			$_POST['password'],
			$_POST['description'],
			$_POST['role']
		);
		$candidate->SetCandidateId($_POST['candidateId']);
		$candidate->SetCreationTime($_POST['creationTime']);
		
		$candidate = UpdateCandidate($database, $candidate);
		echo json_encode($candidate);

	}
}

if("DELETE" == $_SERVER['REQUEST_METHOD']
	&& CheckGetParameters(["cmd"]))
{
	if("deleteCandidate" == $_GET["cmd"])
	{
		$database = new DatabaseOperations();
		$candidateId = $_GET['candidateId'];
		
		$candidate = DeleteCandidate($database, $candidateId);
		echo json_encode($candidate);

	}
}


function GetLastCandidate($database)
{
	$data = $database->ReadData("SELECT * FROM Candidates ORDER BY CreationTime DESC LIMIT 1");
	$candidates = ConvertListToCandidates($data);
	return $candidates;
}

?>
