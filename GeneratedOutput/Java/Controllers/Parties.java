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
interface PartieService
{
	@GET("Parties.php?cmd=getParties")
	Call<List<Partie>> getParties();
	
	@GET("Parties.php?cmd=getPartiesByPartieId")
	Call<List<Partie>> getPartiesByPartieId(@Query("partieId")Integer  partieId);
	
	@POST("Parties.php?cmd=addPartie")
	Call<Partie> addPartie(@Body Partie partie);

}

public class Parties
{
	public static List<Partie> getParties(Call<List<Partie>> call)
	{
		List<Partie> parties;
		
		parties = null;
		
		try
		{
			parties = call.execute().body();
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return parties;
	
	}
	public static List<Partie> getParties()
	{
		List<Partie> parties;
		PartieService service;
		Call<List<Partie>> call;
		
		parties = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartieService.class);
		try
		{
			call = service.getParties();
			parties = getParties(call);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return parties;
	
	}
	
	public static List<Partie> getPartiesByPartieId(Integer  partieId)
	{
		List<Partie> parties;
		PartieService service;
		Call<List<Partie>> call;
		
		parties = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartieService.class);
		try
		{
			call = service.getPartiesByPartieId(partieId);
			parties = getParties(call);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return parties;
	
	}
	
	
	public static void getParties(Call<List<Partie>> call, Callback<List<Partie>> callback)
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
	public static void getParties(Callback<List<Partie>> callback)
	{
		List<Partie> parties;
		PartieService service;
		Call<List<Partie>> call;
		
		parties = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartieService.class);
		try
		{
			call = service.getParties();
			getParties(call, callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
	
	}
	
	public static void getPartiesByPartieId(Integer  partieId, Callback<List<Partie>> callback)
	{
		List<Partie> parties;
		PartieService service;
		Call<List<Partie>> call;
		
		parties = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartieService.class);
		try
		{
			call = service.getPartiesByPartieId(partieId);
			getParties(call, callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
	
	}
	
	
	public static Partie addPartie(Partie partie)
	{
		PartieService service;
		Call<Partie> call;
		
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartieService.class);
		try
		{
			call = service.addPartie(partie);
			partie = call.execute().body();
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return partie;
	
	}
	
	public static void addPartie(Partie partie, Callback<Partie> callback)
	{
		PartieService service;
		Call<Partie> call;
		
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartieService.class);
		try
		{
			call = service.addPartie(partie);
			call.enqueue(callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
	
	}
	

}
