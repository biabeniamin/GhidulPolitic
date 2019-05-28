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
	public static class Candidates
	{
		public static async Task<List<Candidate>> GetCandidates()
		{
			List<Candidate> candidates;
			string data;
			
			candidates = new List<Candidate>();
			data = "";
			
			try
			{
				data = await HttpRequestClient.GetRequest("Candidates.php?cmd=getCandidates");
				candidates = JsonConvert.DeserializeObject<List<Candidate>>(data);
			}
			catch(Exception ee)
			{
				Console.WriteLine(ee.Message);
			}
			
			return candidates;
		
		}
		
		public static async Task<Candidate> AddCandidate(Candidate candidate)
		{
			string data;
			
			data = "";
			
			try
			{
				data = await HttpRequestClient.PostRequest("Candidates.php?cmd=addCandidate", candidate);
				candidate = JsonConvert.DeserializeObject<Candidate>(data);
			}
			catch(Exception ee)
			{
				Console.WriteLine(ee.Message);
			}
			
			return candidate;
		
		}
		
	
	}

}
