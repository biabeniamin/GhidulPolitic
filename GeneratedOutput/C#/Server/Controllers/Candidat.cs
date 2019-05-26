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
	public class CandidatController : ApiController
	{
		// GET candidats/values
		public IEnumerable<Candidat> Get()
		{
			MySqlDataReader reader = new DatabaseOperations().GetReader("SELECT * FROM Candidats");
			List<Candidat> list = new List<Candidat>();
			
			while(reader.Read())
			{
				list.Add(new Candidat(
					(int)reader["CandidatId"],
					(string)reader["Nume"],
					(string)reader["Descriere"],
					(string)reader["Functie"],
					(DateTime)reader["CreationTime"]
				));
			}
			
			return list;
		}
		
		// POST candidats/values
		public void Post([FromBody]Candidat data)
		{
			DatabaseOperations db = new DatabaseOperations();
			MySqlCommand command = new MySqlCommand("INSERT INTO Candidats(Nume,  Descriere,  Functie,  CreationTime) VALUES(@Nume,  @Descriere,  @Functie,  @CreationTime)");
			
			command.Parameters.AddWithValue("@Nume", data.Nume);
			command.Parameters.AddWithValue("@Descriere", data.Descriere);
			command.Parameters.AddWithValue("@Functie", data.Functie);
			command.Parameters.AddWithValue("@CreationTime", DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));
			
			db.ExecuteQuery(command);
		}
		
		// DELETE candidats/values/id
		public void Delete(int id)
		{
			DatabaseOperations db = new DatabaseOperations();
			MySqlCommand command = new MySqlCommand("DELETE FROM Candidats WHERE CandidatId=@Id");
			
			command.Parameters.AddWithValue("@Id", id);
			
			db.ExecuteQuery(command);
		}
		
	
	}

}
