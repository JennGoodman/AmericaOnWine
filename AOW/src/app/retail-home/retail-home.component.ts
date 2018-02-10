import { Component, OnInit } from '@angular/core';

import { FileUploadService } from '../../services/file-upload.service';

@Component({
  selector: 'app-retail-home',
  templateUrl: './retail-home.component.html',
  styleUrls: ['./retail-home.component.css']
})
export class RetailHomeComponent implements OnInit {

  constructor(private fus : FileUploadService) { }

  ngOnInit() {
  }
    fileInput(fileInput : any) {
        this.fus.upload(fileInput);
    }

}
