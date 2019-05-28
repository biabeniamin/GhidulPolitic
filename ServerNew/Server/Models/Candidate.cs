//generated automatically
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks; 
namespace DatabaseFunctionsGenerator
{
	public class Candidate
	{
		private int _candidateId;
		private string _name;
		private string _email;
		private string _password;
		private string _description;
		private string _role;
		private DateTime _creationTime;
		
		[JsonProperty(PropertyName = "candidateId")]
		public int CandidateId
		{
			get
			{
				return _candidateId;
			}
			set
			{
				_candidateId = value;
			}
		}
		
		[JsonProperty(PropertyName = "name")]
		public string Name
		{
			get
			{
				return _name;
			}
			set
			{
				_name = value;
			}
		}
		
		[JsonProperty(PropertyName = "email")]
		public string Email
		{
			get
			{
				return _email;
			}
			set
			{
				_email = value;
			}
		}
		
		[JsonProperty(PropertyName = "password")]
		public string Password
		{
			get
			{
				return _password;
			}
			set
			{
				_password = value;
			}
		}
		
		[JsonProperty(PropertyName = "description")]
		public string Description
		{
			get
			{
				return _description;
			}
			set
			{
				_description = value;
			}
		}
		
		[JsonProperty(PropertyName = "role")]
		public string Role
		{
			get
			{
				return _role;
			}
			set
			{
				_role = value;
			}
		}
		
		[JsonProperty(PropertyName = "creationTime")]
		public DateTime CreationTime
		{
			get
			{
				return _creationTime;
			}
			set
			{
				_creationTime = value;
			}
		}
		
		
		public Candidate(int candidateId, string name, string email, string password, string description, string role, DateTime creationTime)
		{
			_candidateId = candidateId;
			_name = name;
			_email = email;
			_password = password;
			_description = description;
			_role = role;
			_creationTime = creationTime;
		}
		
		public Candidate(string name, string email, string password, string description, string role)
		{
			_name = name;
			_email = email;
			_password = password;
			_description = description;
			_role = role;
		}
		
		public Candidate()
			 :this(
				"Test", //Name
				"Test", //Email
				"Test", //Password
				"Test", //Description
				"Test" //Role
			)
		{
			_candidateId = 0;
			_creationTime = new DateTime(1970, 1, 1, 0, 0, 0);
		}
		
	
	}

}
