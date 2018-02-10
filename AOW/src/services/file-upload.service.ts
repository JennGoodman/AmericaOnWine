import { Injectable } from '@angular/core';

declare var require : any;
require('aws-sdk/dist/aws-sdk');

@Injectable()
export class FileUploadService {

    private aws : any;
    private bucket : any;

    constructor() {
        this.aws = (<any>window).AWS;
        this.aws.config.accessKeyId = 'AKIAJA27DFAOH6D3HBQA';
        this.aws.config.secretAccessKey = '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';
        this.bucket = new this.aws.S3({params: {Bucket: 'americaonwine'}});
    }


    // this function should take a FileList as input
    // Will probably change the any later to ng4-file-upload
    // but for now this will work

    upload(fileInput: any) {
        // Grab the file from the event triggerer
        let file = fileInput.target.files[0];
        let params = {Key: file.name, Body: file};
        this.bucket.upload(params, (err, data) => console.log(err, data));
    }
}
