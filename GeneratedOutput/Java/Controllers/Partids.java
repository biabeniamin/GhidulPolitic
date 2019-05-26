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
interface PartidService
{
	@GET("Partids.php?cmd=getPartids")
	Call<List<Partid>> getPartids();
	
	@GET("Partids.php?cmd=getPartidsByPartidId")
	Call<List<Partid>> getPartidsByPartidId(@Query("partidId")Integer  partidId);
	
	@POST("Partids.php?cmd=addPartid")
	Call<Partid> addPartid(@Body Partid partid);

}

public class Partids
{
	public static List<Partid> getPartids(Call<List<Partid>> call)
	{
		List<Partid> partids;
		
		partids = null;
		
		try
		{
			partids = call.execute().body();
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return partids;
	
	}
	public static List<Partid> getPartids()
	{
		List<Partid> partids;
		PartidService service;
		Call<List<Partid>> call;
		
		partids = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartidService.class);
		try
		{
			call = service.getPartids();
			partids = getPartids(call);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return partids;
	
	}
	
	public static List<Partid> getPartidsByPartidId(Integer  partidId)
	{
		List<Partid> partids;
		PartidService service;
		Call<List<Partid>> call;
		
		partids = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartidService.class);
		try
		{
			call = service.getPartidsByPartidId(partidId);
			partids = getPartids(call);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return partids;
	
	}
	
	
	public static void getPartids(Call<List<Partid>> call, Callback<List<Partid>> callback)
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
	public static void getPartids(Callback<List<Partid>> callback)
	{
		List<Partid> partids;
		PartidService service;
		Call<List<Partid>> call;
		
		partids = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartidService.class);
		try
		{
			call = service.getPartids();
			getPartids(call, callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
	
	}
	
	public static void getPartidsByPartidId(Integer  partidId, Callback<List<Partid>> callback)
	{
		List<Partid> partids;
		PartidService service;
		Call<List<Partid>> call;
		
		partids = null;
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartidService.class);
		try
		{
			call = service.getPartidsByPartidId(partidId);
			getPartids(call, callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
	
	}
	
	
	public static Partid addPartid(Partid partid)
	{
		PartidService service;
		Call<Partid> call;
		
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartidService.class);
		try
		{
			call = service.addPartid(partid);
			partid = call.execute().body();
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
		
		return partid;
	
	}
	
	public static void addPartid(Partid partid, Callback<Partid> callback)
	{
		PartidService service;
		Call<Partid> call;
		
		
		service = RetrofitInstance.GetRetrofitInstance().create(PartidService.class);
		try
		{
			call = service.addPartid(partid);
			call.enqueue(callback);
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
	
	}
	

}
