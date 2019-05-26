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
	public static class Candidats
	{
		public static async Task<List<Candidat>> GetCandidats()
		{
			List<Candidat> candidats;
			string data;
			
			candidats = new List<Candidat>();
			data = "";
			
			try
			{
				data = await HttpRequestClient.GetRequest("Candidats.php?cmd=getCandidats");
				candidats = JsonConvert.DeserializeObject<List<Candidat>>(data);
			}
			catch(Exception ee)
			{
				Console.WriteLine(ee.Message);
			}
			
			return candidats;
		
		}
		
		public static async Task<Candidat> AddCandidat(Candidat candidat)
		{
			string data;
			
			data = "";
			
			try
			{
				data = await HttpRequestClient.PostRequest("Candidats.php?cmd=addCandidat", candidat);
				candidat = JsonConvert.DeserializeObject<Candidat>(data);
			}
			catch(Exception ee)
			{
				Console.WriteLine(ee.Message);
			}
			
			return candidat;
		
		}
		
	
	}

}
