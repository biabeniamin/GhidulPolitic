<?php
//generated automatically
class Candidate
{
	var $candidateId;
	var $name;
	var $email;
	var $password;
	var $description;
	var $role;
	var $creationTime;

	function GetCandidateId()
	{
		return $this->candidateId;
	}
	function SetCandidateId($value)
	{
		$this->candidateId = $value;
	}
	
	function GetName()
	{
		return $this->name;
	}
	function SetName($value)
	{
		$this->name = $value;
	}
	
	function GetEmail()
	{
		return $this->email;
	}
	function SetEmail($value)
	{
		$this->email = $value;
	}
	
	function GetPassword()
	{
		return $this->password;
	}
	function SetPassword($value)
	{
		$this->password = $value;
	}
	
	function GetDescription()
	{
		return $this->description;
	}
	function SetDescription($value)
	{
		$this->description = $value;
	}
	
	function GetRole()
	{
		return $this->role;
	}
	function SetRole($value)
	{
		$this->role = $value;
	}
	
	function GetCreationTime()
	{
		return $this->creationTime;
	}
	function SetCreationTime($value)
	{
		$this->creationTime = $value;
	}
	

	function Candidate($Name, $Email, $Password, $Description, $Role)
	{
		$this->candidateId = 0;
	
		$this->name = $Name;
		$this->email = $Email;
		$this->password = $Password;
		$this->description = $Description;
		$this->role = $Role;
	}

}
?>
