<?php
//generated automatically
class Candidat
{
	var $candidatId;
	var $nume;
	var $descriere;
	var $functie;
	var $creationTime;

	function GetCandidatId()
	{
		return $this->candidatId;
	}
	function SetCandidatId($value)
	{
		$this->candidatId = $value;
	}
	
	function GetNume()
	{
		return $this->nume;
	}
	function SetNume($value)
	{
		$this->nume = $value;
	}
	
	function GetDescriere()
	{
		return $this->descriere;
	}
	function SetDescriere($value)
	{
		$this->descriere = $value;
	}
	
	function GetFunctie()
	{
		return $this->functie;
	}
	function SetFunctie($value)
	{
		$this->functie = $value;
	}
	
	function GetCreationTime()
	{
		return $this->creationTime;
	}
	function SetCreationTime($value)
	{
		$this->creationTime = $value;
	}
	

	function Candidat($Nume, $Descriere, $Functie)
	{
		$this->candidatId = 0;
	
		$this->nume = $Nume;
		$this->descriere = $Descriere;
		$this->functie = $Functie;
	}

}
?>
