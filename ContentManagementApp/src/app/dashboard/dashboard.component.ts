import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddContentServiceService } from '../add-content-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private addContentService:AddContentServiceService,private router:Router) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('Jwt_Token'))
    this.getContentData();
  }

  contentData:any
  error:String=''

  getContentData(){
    this.addContentService.getAllContent().subscribe(response=>{ 
      this.contentData=response;
    },(error=>{
      this.error=error;
      alert("Error in getting data");
      this.router.navigateByUrl('/register')
    }))
  }

}
