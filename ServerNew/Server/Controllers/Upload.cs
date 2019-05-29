using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace Server.Controllers
{
    public class Upload : ApiController
  {
        // GET: Upload
        public string Index()
        {
            return "asfsa";
        }

        public void Post([FromBody]string data)
        {
      int i = 0;
      i++;
        }
    }
}
