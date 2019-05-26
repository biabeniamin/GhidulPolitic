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

public class Partie
{
	private Integer  partieId;
	private String name;
	private Integer  position;
	private Date creationTime;
	
	public Integer  getPartieId()
	{
		return this.partieId;
	}
	
	public void setPartieId(Integer  partieId)
	{
		this.partieId = partieId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Integer  getPosition()
	{
		return this.position;
	}
	
	public void setPosition(Integer  position)
	{
		this.position = position;
	}
	
	public Date getCreationTime()
	{
		return this.creationTime;
	}
	
	public void setCreationTime(Date creationTime)
	{
		this.creationTime = creationTime;
	}
	
	
	public Partie(String name, Integer  position)
	{
		this.name = name;
		this.position = position;
	}
	
	public Partie()
	{
		this(
			"Test", //Name
			0 //Position
		);
		this.partieId = 0;
		this.creationTime = new Date(0);
	
	}
	

}
