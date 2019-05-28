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
	public static class Parties
	{
		public static async Task<List<Partie>> GetParties()
		{
			List<Partie> parties;
			string data;
			
			parties = new List<Partie>();
			data = "";
			
			try
			{
				data = await HttpRequestClient.GetRequest("Parties.php?cmd=getParties");
				parties = JsonConvert.DeserializeObject<List<Partie>>(data);
			}
			catch(Exception ee)
			{
				Console.WriteLine(ee.Message);
			}
			
			return parties;
		
		}
		
		public static async Task<Partie> AddPartie(Partie partie)
		{
			string data;
			
			data = "";
			
			try
			{
				data = await HttpRequestClient.PostRequest("Parties.php?cmd=addPartie", partie);
				partie = JsonConvert.DeserializeObject<Partie>(data);
			}
			catch(Exception ee)
			{
				Console.WriteLine(ee.Message);
			}
			
			return partie;
		
		}
		
	
	}

}
