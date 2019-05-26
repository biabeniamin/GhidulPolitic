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
	public class PartidController : ApiController
	{
		// GET partids/values
		public IEnumerable<Partid> Get()
		{
			MySqlDataReader reader = new DatabaseOperations().GetReader("SELECT * FROM Partids");
			List<Partid> list = new List<Partid>();
			
			while(reader.Read())
			{
				list.Add(new Partid(
					(int)reader["PartidId"],
					(string)reader["Nume"],
					(int)reader["Pozitie"],
					(DateTime)reader["CreationTime"]
				));
			}
			
			return list;
		}
		
		// POST partids/values
		public void Post([FromBody]Partid data)
		{
			DatabaseOperations db = new DatabaseOperations();
			MySqlCommand command = new MySqlCommand("INSERT INTO Partids(Nume,  Pozitie,  CreationTime) VALUES(@Nume,  @Pozitie,  @CreationTime)");
			
			command.Parameters.AddWithValue("@Nume", data.Nume);
			command.Parameters.AddWithValue("@Pozitie", data.Pozitie);
			command.Parameters.AddWithValue("@CreationTime", DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));
			
			db.ExecuteQuery(command);
		}
		
		// DELETE partids/values/id
		public void Delete(int id)
		{
			DatabaseOperations db = new DatabaseOperations();
			MySqlCommand command = new MySqlCommand("DELETE FROM Partids WHERE PartidId=@Id");
			
			command.Parameters.AddWithValue("@Id", id);
			
			db.ExecuteQuery(command);
		}
		
	
	}

}
