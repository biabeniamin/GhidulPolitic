//generated automatically
package com.example.biabe.DatabaseFunctionsGenerator.Models;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.POST;
import retrofit2.http.Body;
import java.util.Date;

public class Candidat
{
	private Integer  candidatId;
	private String nume;
	private String descriere;
	private String functie;
	private Date creationTime;
	
	public Integer  getCandidatId()
	{
		return this.candidatId;
	}
	
	public void setCandidatId(Integer  candidatId)
	{
		this.candidatId = candidatId;
	}
	
	public String getNume()
	{
		return this.nume;
	}
	
	public void setNume(String nume)
	{
		this.nume = nume;
	}
	
	public String getDescriere()
	{
		return this.descriere;
	}
	
	public void setDescriere(String descriere)
	{
		this.descriere = descriere;
	}
	
	public String getFunctie()
	{
		return this.functie;
	}
	
	public void setFunctie(String functie)
	{
		this.functie = functie;
	}
	
	public Date getCreationTime()
	{
		return this.creationTime;
	}
	
	public void setCreationTime(Date creationTime)
	{
		this.creationTime = creationTime;
	}
	
	
	public Candidat(String nume, String descriere, String functie)
	{
		this.nume = nume;
		this.descriere = descriere;
		this.functie = functie;
	}
	
	public Candidat()
	{
		this(
			"Test", //Nume
			"Test", //Descriere
			"Test" //Functie
		);
		this.candidatId = 0;
		this.creationTime = new Date(0);
	
	}
	

}
