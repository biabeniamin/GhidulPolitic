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
	public class Candidat
	{
		private int _candidatId;
		private string _nume;
		private string _descriere;
		private string _functie;
		private DateTime _creationTime;
		
		[JsonProperty(PropertyName = "candidatId")]
		public int CandidatId
		{
			get
			{
				return _candidatId;
			}
			set
			{
				_candidatId = value;
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
		
		[JsonProperty(PropertyName = "descriere")]
		public string Descriere
		{
			get
			{
				return _descriere;
			}
			set
			{
				_descriere = value;
			}
		}
		
		[JsonProperty(PropertyName = "functie")]
		public string Functie
		{
			get
			{
				return _functie;
			}
			set
			{
				_functie = value;
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
		
		
		public Candidat(int candidatId, string nume, string descriere, string functie, DateTime creationTime)
		{
			_candidatId = candidatId;
			_nume = nume;
			_descriere = descriere;
			_functie = functie;
			_creationTime = creationTime;
		}
		
		public Candidat(string nume, string descriere, string functie)
		{
			_nume = nume;
			_descriere = descriere;
			_functie = functie;
		}
		
		public Candidat()
			 :this(
				"Test", //Nume
				"Test", //Descriere
				"Test" //Functie
			)
		{
			_candidatId = 0;
			_creationTime = new DateTime(1970, 1, 1, 0, 0, 0);
		}
		
	
	}

}
