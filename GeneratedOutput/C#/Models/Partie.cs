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
	public class Partie
	{
		private int _partieId;
		private string _name;
		private int _position;
		private DateTime _creationTime;
		
		[JsonProperty(PropertyName = "partieId")]
		public int PartieId
		{
			get
			{
				return _partieId;
			}
			set
			{
				_partieId = value;
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
		
		[JsonProperty(PropertyName = "position")]
		public int Position
		{
			get
			{
				return _position;
			}
			set
			{
				_position = value;
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
		
		
		public Partie(int partieId, string name, int position, DateTime creationTime)
		{
			_partieId = partieId;
			_name = name;
			_position = position;
			_creationTime = creationTime;
		}
		
		public Partie(string name, int position)
		{
			_name = name;
			_position = position;
		}
		
		public Partie()
			 :this(
				"Test", //Name
				0 //Position
			)
		{
			_partieId = 0;
			_creationTime = new DateTime(1970, 1, 1, 0, 0, 0);
		}
		
	
	}

}
