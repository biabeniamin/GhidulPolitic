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
interface CandidatService
{
	@GET("Candidats.php?cmd=getCandidats")
	Call<List<Candidat>> getCandidats();
	
	@GET("Candidats.php?cmd=getCandidatsByCandidatId")
	Call<List<Candidat>> getCandidatsByCandidatId(@Query("candidatId")Integer  candidatId);
	
	@POST("Candidats.php?cmd=addCandidat")
	Call<Candidat> addCandidat(@Body Candidat candidat);

}

public class Candidats
{
	public static List<Candidat> getCandidats(Call<List<Candidat>> call)
	{
		List<Candidat> candidats;
		
		candidats = null;
		
		try
		{
			candidats = call.execute().body();
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return candidats;
	
	}
	public static List<Candidat> getCandidats()
	{
		List<Candidat> candidats;
		CandidatService service;
		Call<List<Candidat>> call;
		
		candidats = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidatService.class);
		try
		{
			call = service.getCandidats();
			candidats = getCandidats(call);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return candidats;
	
	}
	
	public static List<Candidat> getCandidatsByCandidatId(Integer  candidatId)
	{
		List<Candidat> candidats;
		CandidatService service;
		Call<List<Candidat>> call;
		
		candidats = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidatService.class);
		try
		{
			call = service.getCandidatsByCandidatId(candidatId);
			candidats = getCandidats(call);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return candidats;
	
	}
	
	
	public static void getCandidats(Call<List<Candidat>> call, Callback<List<Candidat>> callback)
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
	public static void getCandidats(Callback<List<Candidat>> callback)
	{
		List<Candidat> candidats;
		CandidatService service;
		Call<List<Candidat>> call;
		
		candidats = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidatService.class);
		try
		{
			call = service.getCandidats();
			getCandidats(call, callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
	
	}
	
	public static void getCandidatsByCandidatId(Integer  candidatId, Callback<List<Candidat>> callback)
	{
		List<Candidat> candidats;
		CandidatService service;
		Call<List<Candidat>> call;
		
		candidats = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidatService.class);
		try
		{
			call = service.getCandidatsByCandidatId(candidatId);
			getCandidats(call, callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
	
	}
	
	
	public static Candidat addCandidat(Candidat candidat)
	{
		CandidatService service;
		Call<Candidat> call;
		
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidatService.class);
		try
		{
			call = service.addCandidat(candidat);
			candidat = call.execute().body();
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return candidat;
	
	}
	
	public static void addCandidat(Candidat candidat, Callback<Candidat> callback)
	{
		CandidatService service;
		Call<Candidat> call;
		
		
		service = RetrofitInstance.GetRetrofitInstance().create(CandidatService.class);
		try
		{
			call = service.addCandidat(candidat);
			call.enqueue(callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
	
	}
	

}
