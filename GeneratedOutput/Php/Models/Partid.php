<?php
//generated automatically
class Partid
{
	var $partidId;
	var $nume;
	var $pozitie;
	var $creationTime;

	function GetPartidId()
	{
		return $this->partidId;
	}
	function SetPartidId($value)
	{
		$this->partidId = $value;
	}
	
	function GetNume()
	{
		return $this->nume;
	}
	function SetNume($value)
	{
		$this->nume = $value;
	}
	
	function GetPozitie()
	{
		return $this->pozitie;
	}
	function SetPozitie($value)
	{
		$this->pozitie = $value;
	}
	
	function GetCreationTime()
	{
		return $this->creationTime;
	}
	function SetCreationTime($value)
	{
		$this->creationTime = $value;
	}
	

	function Partid($Nume, $Pozitie)
	{
		$this->partidId = 0;
	
		$this->nume = $Nume;
		$this->pozitie = $Pozitie;
	}

}
?>
