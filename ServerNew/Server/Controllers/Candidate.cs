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
	public class CandidateController : ApiController
	{
    // GET candidates/values
    public IEnumerable<Candidate> Get()
    {
      MySqlDataReader reader = new DatabaseOperations().GetReader("SELECT * FROM Candidates");
      List<Candidate> list = new List<Candidate>();

      while (reader.Read())
      {
        list.Add(new Candidate(
            (int)reader["CandidateId"],
            (string)reader["Name"],
            (string)reader["Email"],
            (string)reader["Password"],
            (string)reader["Description"],
            (string)reader["Role"],
            (int)reader["PartieId"],
            (DateTime)reader["CreationTime"]
        ));
      }

      return list;
    }

    // GET candidates/candidateId
    public IEnumerable<Candidate> Get(int id)
    {
      MySqlDataReader reader = new DatabaseOperations().GetReader($"SELECT * FROM Candidates where CandidateId = {id}");
      List<Candidate> list = new List<Candidate>();

      while (reader.Read())
      {
        list.Add(new Candidate(
            (int)reader["CandidateId"],
            (string)reader["Name"],
            (string)reader["Email"],
            (string)reader["Password"],
            (string)reader["Description"],
            (string)reader["Role"],
            (int)reader["PartieId"],
            (DateTime)reader["CreationTime"]
        ));
      }

      return list;
    }

    // POST candidates/values
    public void Post([FromBody]Candidate data)
    {
      DatabaseOperations db = new DatabaseOperations();
      MySqlCommand command = new MySqlCommand("INSERT INTO Candidates(Name,  Email,  Password,  Description,  Role, PartieId,  CreationTime) VALUES(@Name,  @Email,  @Password,  @Description,  @Role, @PartieId,  @CreationTime)");

      command.Parameters.AddWithValue("@Name", data.Name);
      command.Parameters.AddWithValue("@Email", data.Email);
      command.Parameters.AddWithValue("@Password", data.Password);
      command.Parameters.AddWithValue("@Description", data.Description);
      command.Parameters.AddWithValue("@Role", data.Role);
      command.Parameters.AddWithValue("@PartieId", data.PartieId);
      command.Parameters.AddWithValue("@CreationTime", DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));

      db.ExecuteQuery(command);
    }

    // PUT candidates/valuesd
    public void PUT([FromBody]Candidate data)
    {
      DatabaseOperations db = new DatabaseOperations();
      MySqlCommand command = new MySqlCommand("UPDATE  Candidates SET Name=@Name,  Email=@Email,  Password=@Password,  Description=@Description,  Role=@Role WHERE CandidateId=@Id");

      command.Parameters.AddWithValue("@Id", data.CandidateId);
      command.Parameters.AddWithValue("@Name", data.Name);
      command.Parameters.AddWithValue("@Email", data.Email);
      command.Parameters.AddWithValue("@Password", data.Password);
      command.Parameters.AddWithValue("@Description", data.Description);
      command.Parameters.AddWithValue("@Role", data.Role);
      command.Parameters.AddWithValue("@CreationTime", DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));

      db.ExecuteQuery(command);
    }

    // DELETE candidates/values/id
    public void Delete(int id)
		{
			DatabaseOperations db = new DatabaseOperations();
			MySqlCommand command = new MySqlCommand("DELETE FROM Candidates WHERE CandidateId=@Id");
			
			command.Parameters.AddWithValue("@Id", id);
			
			db.ExecuteQuery(command);
		}
		
	
	}

}
