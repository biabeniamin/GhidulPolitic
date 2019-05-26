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

public class Candidate
{
	private Integer  candidateId;
	private String name;
	private String email;
	private String password;
	private String description;
	private String role;
	private Date creationTime;
	
	public Integer  getCandidateId()
	{
		return this.candidateId;
	}
	
	public void setCandidateId(Integer  candidateId)
	{
		this.candidateId = candidateId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getRole()
	{
		return this.role;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public Date getCreationTime()
	{
		return this.creationTime;
	}
	
	public void setCreationTime(Date creationTime)
	{
		this.creationTime = creationTime;
	}
	
	
	public Candidate(String name, String email, String password, String description, String role)
	{
		this.name = name;
		this.email = email;
		this.password = password;
		this.description = description;
		this.role = role;
	}
	
	public Candidate()
	{
		this(
			"Test", //Name
			"Test", //Email
			"Test", //Password
			"Test", //Description
			"Test" //Role
		);
		this.candidateId = 0;
		this.creationTime = new Date(0);
	
	}
	

}
