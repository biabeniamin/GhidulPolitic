//generated automatically
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Server.Controllers;
namespace DatabaseFunctionsGenerator
{
	public class PartieController : ApiController
	{
		// GET parties/values
		public IEnumerable<Partie> Get()
		{
			MySqlDataReader reader = new DatabaseOperations().GetReader("SELECT * FROM Parties");
			List<Partie> list = new List<Partie>();
			
			while(reader.Read())
			{
				list.Add(new Partie(
					(int)reader["PartieId"],
					(string)reader["Name"],
					(int)reader["Position"],
					(DateTime)reader["CreationTime"]
				));
			}
			
			return list;
		}
		
		// POST parties/values
		public void Post([FromBody]Partie data)
		{
			DatabaseOperations db = new DatabaseOperations();
			MySqlCommand command = new MySqlCommand("INSERT INTO Parties(Name,  Position,  CreationTime) VALUES(@Name,  @Position,  @CreationTime)");
			
			command.Parameters.AddWithValue("@Name", data.Name);
			command.Parameters.AddWithValue("@Position", data.Position);
			command.Parameters.AddWithValue("@CreationTime", DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));
			
			db.ExecuteQuery(command);
		}
		
		// DELETE parties/values/id
		public void Delete(int id)
		{
			DatabaseOperations db = new DatabaseOperations();
			MySqlCommand command = new MySqlCommand("DELETE FROM Parties WHERE PartieId=@Id");
			
			command.Parameters.AddWithValue("@Id", id);
			
			db.ExecuteQuery(command);
		}
		
	
	}

}
