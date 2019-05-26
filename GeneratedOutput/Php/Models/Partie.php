<?php
//generated automatically
class Partie
{
	var $partieId;
	var $name;
	var $position;
	var $creationTime;

	function GetPartieId()
	{
		return $this->partieId;
	}
	function SetPartieId($value)
	{
		$this->partieId = $value;
	}
	
	function GetName()
	{
		return $this->name;
	}
	function SetName($value)
	{
		$this->name = $value;
	}
	
	function GetPosition()
	{
		return $this->position;
	}
	function SetPosition($value)
	{
		$this->position = $value;
	}
	
	function GetCreationTime()
	{
		return $this->creationTime;
	}
	function SetCreationTime($value)
	{
		$this->creationTime = $value;
	}
	

	function Partie($Name, $Position)
	{
		$this->partieId = 0;
	
		$this->name = $Name;
		$this->position = $Position;
	}

}
?>
