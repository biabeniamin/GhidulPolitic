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
using System.Web.Http.ModelBinding;
using System.IO;
using System.Threading.Tasks;
using System.Net.Http.Headers;
using System.Collections.Specialized;
using System.Web.Configuration;
using System.Web;

namespace DatabaseFunctionsGenerator
{
  public class Foo
  {
    public byte[] Stream { get; set; }
    public string Bar { get; set; }
  }
  public class FileModelBinder : System.Web.Http.ModelBinding.IModelBinder
  {
    public FileModelBinder()
    {

    }

    public bool BindModel(
        System.Web.Http.Controllers.HttpActionContext actionContext,
        System.Web.Http.ModelBinding.ModelBindingContext bindingContext)
    {
      if (actionContext.Request.Content.IsMimeMultipartContent())
      {
        var inputModel = new Foo();

        inputModel.Bar = "";  //From the actionContext.Request etc
        inputModel.Stream = actionContext.Request.Content.ReadAsByteArrayAsync()
                                        .Result;

        bindingContext.Model = inputModel;
        return true;
      }
      else
      {
        throw new HttpResponseException(actionContext.Request.CreateResponse(
         HttpStatusCode.NotAcceptable, "This request is not properly formatted"));
      }
    }
  }


  public class InMemoryMultipartFormDataStreamProvider : MultipartStreamProvider
  {
    private NameValueCollection _formData = new NameValueCollection();
    private List<HttpContent> _fileContents = new List<HttpContent>();

    // Set of indexes of which HttpContents we designate as form data  
    private Collection<bool> _isFormData = new Collection<bool>();

    /// <summary>  
    /// Gets a <see cref="NameValueCollection"/> of form data passed as part of the multipart form data.  
    /// </summary>  
    public NameValueCollection FormData
    {
      get { return _formData; }
    }

    /// <summary>  
    /// Gets list of <see cref="HttpContent"/>s which contain uploaded files as in-memory representation.  
    /// </summary>  
    public List<HttpContent> Files
    {
      get { return _fileContents; }
    }

    public override Stream GetStream(HttpContent parent, HttpContentHeaders headers)
    {
      // For form data, Content-Disposition header is a requirement  
      ContentDispositionHeaderValue contentDisposition = headers.ContentDisposition;
      if (contentDisposition != null)
      {
        // We will post process this as form data  
        _isFormData.Add(String.IsNullOrEmpty(contentDisposition.FileName));

        return new MemoryStream();
      }

      // If no Content-Disposition header was present.  
      throw new InvalidOperationException(string.Format("Did not find required '{0}' header field in MIME multipart body part..", "Content-Disposition"));
    }

    /// <summary>  
    /// Read the non-file contents as form data.  
    /// </summary>  
    /// <returns></returns>  
    public override async Task ExecutePostProcessingAsync()
    {
      // Find instances of non-file HttpContents and read them asynchronously  
      // to get the string content and then add that as form data  
      for (int index = 0; index < Contents.Count; index++)
      {
        if (_isFormData[index])
        {
          HttpContent formContent = Contents[index];
          // Extract name from Content-Disposition header. We know from earlier that the header is present.  
          ContentDispositionHeaderValue contentDisposition = formContent.Headers.ContentDisposition;
          string formFieldName = UnquoteToken(contentDisposition.Name) ?? String.Empty;

          // Read the contents as string data and add to form data  
          string formFieldValue = await formContent.ReadAsStringAsync();
          FormData.Add(formFieldName, formFieldValue);
        }
        else
        {
          _fileContents.Add(Contents[index]);
        }
      }
    }

    /// <summary>  
    /// Remove bounding quotes on a token if present  
    /// </summary>  
    /// <param name="token">Token to unquote.</param>  
    /// <returns>Unquoted token.</returns>  
    private static string UnquoteToken(string token)
    {
      if (String.IsNullOrWhiteSpace(token))
      {
        return token;
      }

      if (token.StartsWith("\"", StringComparison.Ordinal) && token.EndsWith("\"", StringComparison.Ordinal) && token.Length > 1)
      {
        return token.Substring(1, token.Length - 2);
      }

      return token;
    }





  }


  public class MessageController : ApiController
	{

    // GET: Upload
    public string Get()
    {
      return "asfsa";
    }

    public void Post(MultipartDataMediaFormatter.Infrastructure.FormData formDat)
    {
      int i = 0;
      i++;

      /*using (var fs = new FileStream("D:\\imaginePrimita.jpg", FileMode.Create, FileAccess.Write))
      {
        fs.Write(foo.Stream, 0, foo.Stream.Length);
        fs.Close();
      }*/
    }


    [HttpPost]
    [Route("api/upload/MediaUpload")]
    public async Task<HttpResponseMessage> MediaUpload()
    {
      // Check if the request contains multipart/form-data.  
      if (!Request.Content.IsMimeMultipartContent())
      {
        throw new HttpResponseException(HttpStatusCode.UnsupportedMediaType);
      }

      var provider = await Request.Content.ReadAsMultipartAsync<InMemoryMultipartFormDataStreamProvider>(new InMemoryMultipartFormDataStreamProvider());
      //access form data  
      NameValueCollection formData = provider.FormData;
      //access files  
      IList<HttpContent> files = provider.Files;

      HttpContent file1 = files[0];
      var thisFileName = file1.Headers.ContentDisposition.FileName.Trim('\"');

      string filename = String.Empty;
      Stream input = await file1.ReadAsStreamAsync();
      string directoryName = String.Empty;
      string URL = String.Empty;
      string tempDocUrl = "http://localhost:65165";

      //if (formData["ClientDocs"] == "ClientDocs")





      var path = @"D:\xampp\htdocs\GhidImages";
      filename = System.IO.Path.Combine(path, formData["userId"]+".jpg");

      //Deletion exists file  
      if (File.Exists(filename))
      {
        File.Delete(filename);
      }

      string DocsPath = tempDocUrl + "/" + "ClientDocument" + "/";
      URL = DocsPath + thisFileName;



      //Directory.CreateDirectory(@directoryName);  
      using (Stream file = File.OpenWrite(filename))
      {
        input.CopyTo(file);
        //close file  
        file.Close();
      }

      var response = Request.CreateResponse(HttpStatusCode.OK);
      response.Headers.Add("DocsUrl", URL);
      return response;
    }

  }

}
