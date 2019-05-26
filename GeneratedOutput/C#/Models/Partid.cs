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
	public class Partid
	{
		private int _partidId;
		private string _nume;
		private int _pozitie;
		private DateTime _creationTime;
		
		[JsonProperty(PropertyName = "partidId")]
		public int PartidId
		{
			get
			{
				return _partidId;
			}
			set
			{
				_partidId = value;
			}
		}
		
		[JsonProperty(PropertyName = "nume")]
		public string Nume
		{
			get
			{
				return _nume;
			}
			set
			{
				_nume = value;
			}
		}
		
		[JsonProperty(PropertyName = "pozitie")]
		public int Pozitie
		{
			get
			{
				return _pozitie;
			}
			set
			{
				_pozitie = value;
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
		
		
		public Partid(int partidId, string nume, int pozitie, DateTime creationTime)
		{
			_partidId = partidId;
			_nume = nume;
			_pozitie = pozitie;
			_creationTime = creationTime;
		}
		
		public Partid(string nume, int pozitie)
		{
			_nume = nume;
			_pozitie = pozitie;
		}
		
		public Partid()
			 :this(
				"Test", //Nume
				0 //Pozitie
			)
		{
			_partidId = 0;
			_creationTime = new DateTime(1970, 1, 1, 0, 0, 0);
		}
		
	
	}

}
