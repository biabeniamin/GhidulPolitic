import { Component, OnInit } from '@angular/core';
import { FileUploader, FileSelectDirective } from 'ng2-file-upload';
import { CookieService } from 'ngx-cookie-service';

const URL = 'http://localhost:65165/api/upload/MediaUpload';


@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {
  public uploader: FileUploader = new FileUploader({url: URL, itemAlias: 'photo'});

  constructor(private cookieService: CookieService) { }


  ngOnInit() {
    this.uploader.onAfterAddingFile = (file) => { file.withCredentials = false;};
    this.uploader.onBuildItemForm = (fileItem: any, form: any) => {
      let userId = this.cookieService.get("userId");
      form.append('userId' , userId);
     };
    this.uploader.onCompleteItem = (item: any, response: any, status: any, headers: any) => {
         console.log('ImageUpload:uploaded:', item, status, response);
         alert('File uploaded successfully');
     };
  }

}
