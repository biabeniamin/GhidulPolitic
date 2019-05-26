//generated automatically
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks; 
using Newtonsoft.Json;
namespace DatabaseFunctionsGenerator
{
	public static class Partids
	{
		public static async Task<List<Partid>> GetPartids()
		{
			List<Partid> partids;
			string data;
			
			partids = new List<Partid>();
			data = "";
			
			try
			{
				data = await HttpRequestClient.GetRequest("Partids.php?cmd=getPartids");
				partids = JsonConvert.DeserializeObject<List<Partid>>(data);
			}
			catch(Exception ee)
			{
				Console.WriteLine(ee.Message);
			}
			
			return partids;
		
		}
		
		public static async Task<Partid> AddPartid(Partid partid)
		{
			string data;
			
			data = "";
			
			try
			{
				data = await HttpRequestClient.PostRequest("Partids.php?cmd=addPartid", partid);
				partid = JsonConvert.DeserializeObject<Partid>(data);
			}
			catch(Exception ee)
			{
				Console.WriteLine(ee.Message);
			}
			
			return partid;
		
		}
		
	
	}

}
