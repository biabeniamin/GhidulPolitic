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

public class Partid
{
	private Integer  partidId;
	private String nume;
	private Integer  pozitie;
	private Date creationTime;
	
	public Integer  getPartidId()
	{
		return this.partidId;
	}
	
	public void setPartidId(Integer  partidId)
	{
		this.partidId = partidId;
	}
	
	public String getNume()
	{
		return this.nume;
	}
	
	public void setNume(String nume)
	{
		this.nume = nume;
	}
	
	public Integer  getPozitie()
	{
		return this.pozitie;
	}
	
	public void setPozitie(Integer  pozitie)
	{
		this.pozitie = pozitie;
	}
	
	public Date getCreationTime()
	{
		return this.creationTime;
	}
	
	public void setCreationTime(Date creationTime)
	{
		this.creationTime = creationTime;
	}
	
	
	public Partid(String nume, Integer  pozitie)
	{
		this.nume = nume;
		this.pozitie = pozitie;
	}
	
	public Partid()
	{
		this(
			"Test", //Nume
			0 //Pozitie
		);
		this.partidId = 0;
		this.creationTime = new Date(0);
	
	}
	

}
