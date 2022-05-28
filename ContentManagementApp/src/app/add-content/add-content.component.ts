import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AddContentServiceService } from '../add-content-service.service';

@Component({
  selector: 'app-add-content',
  templateUrl: './add-content.component.html',
  styleUrls: ['./add-content.component.css']
})
export class AddContentComponent implements OnInit {

  constructor(private addContentService:AddContentServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  addContentForm=new FormGroup({
    contentId:new FormControl('',Validators.required),
    contentTitle:new FormControl('',Validators.required),
    contentType:new FormControl(''),
    contentDate:new FormControl(''),
    contentBody:new FormControl('')
  })

  error:String=''

  addContent(){
    this.addContentService.addContent(this.addContentForm.value).subscribe(response=>{
      alert("Content added successfully");
      this.router.navigateByUrl('/dashboard');
    },(error=>{
      this.error=error;
      alert("Error in adding data");
      this.router.navigateByUrl('/register')
    }))
  }

}
