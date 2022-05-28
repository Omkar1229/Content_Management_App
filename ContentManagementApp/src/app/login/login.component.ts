import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService:LoginServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  loginForm=new FormGroup({
    userId:new FormControl('',Validators.required),
    password:new FormControl('',Validators.required),
   
  })

  error:String=''

  login(){
    this.loginService.loginUser(this.loginForm.value).subscribe(response=>{
      alert("Successfully logged in");
      localStorage.setItem("Jwt_Token",response.token);
      this.loginService.userLoggedIn();
      this.router.navigateByUrl('/dashboard')
    },(error=>{
      this.error=error;
      alert("Error in logging in");
      window.location.reload()
    }))
  }

}
