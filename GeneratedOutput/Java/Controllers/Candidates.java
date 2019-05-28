//generated automatically
package com.example.biabe.DatabaseFunctionsGenerator;
import com.example.biabe.DatabaseFunctionsGenerator.Models.*;
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
interface CandidateService
{
	@GET("Candidates.php?cmd=getCandidates")
	Call<List<Candidate>> getCandidates();
	
	@GET("Candidates.php?cmd=getCandidatesByCandidateId")
	Call<List<Candidate>> getCandidatesByCandidateId(@Query("candidateId")Integer  candidateId);
	
	@POST("Candidates.php?cmd=addCandidate")
	Call<Candidate> addCandidate(@Body Candidate candidate);

}

public class Candidates
{
	public static List<Candidate> getCandidates(Call<List<Candidate>> call)
	{
		List<Candidate> candidates;
		
		candidates = null;
		
		try
		{
			candidates = call.execute().body();
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return candidates;
	
	}
	public static List<Candidate> getCandidates()
	{
		List<Candidate> candidates;
		CandidateService service;
		Call<List<Candidate>> call;
		
		candidates = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidateService.class);
		try
		{
			call = service.getCandidates();
			candidates = getCandidates(call);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return candidates;
	
	}
	
	public static List<Candidate> getCandidatesByCandidateId(Integer  candidateId)
	{
		List<Candidate> candidates;
		CandidateService service;
		Call<List<Candidate>> call;
		
		candidates = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidateService.class);
		try
		{
			call = service.getCandidatesByCandidateId(candidateId);
			candidates = getCandidates(call);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return candidates;
	
	}
	
	
	public static void getCandidates(Call<List<Candidate>> call, Callback<List<Candidate>> callback)
	{
		try
		{
			call.enqueue(callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
	
	}
	public static void getCandidates(Callback<List<Candidate>> callback)
	{
		List<Candidate> candidates;
		CandidateService service;
		Call<List<Candidate>> call;
		
		candidates = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidateService.class);
		try
		{
			call = service.getCandidates();
			getCandidates(call, callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
	
	}
	
	public static void getCandidatesByCandidateId(Integer  candidateId, Callback<List<Candidate>> callback)
	{
		List<Candidate> candidates;
		CandidateService service;
		Call<List<Candidate>> call;
		
		candidates = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidateService.class);
		try
		{
			call = service.getCandidatesByCandidateId(candidateId);
			getCandidates(call, callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
	
	}
	
	
	public static Candidate addCandidate(Candidate candidate)
	{
		CandidateService service;
		Call<Candidate> call;
		
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidateService.class);
		try
		{
			call = service.addCandidate(candidate);
			candidate = call.execute().body();
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return candidate;
	
	}
	
	public static void addCandidate(Candidate candidate, Callback<Candidate> callback)
	{
		CandidateService service;
		Call<Candidate> call;
		
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidateService.class);
		try
		{
			call = service.addCandidate(candidate);
			call.enqueue(callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
	
	}
	

}
