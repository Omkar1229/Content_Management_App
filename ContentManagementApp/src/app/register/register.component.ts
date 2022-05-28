import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterServiceService } from '../register-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private registerService:RegisterServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  registerForm=new FormGroup({
    userName:new FormControl('',Validators.required),
    password:new FormControl('',Validators.required),
    emailId:new FormControl(''),
    address:new FormControl('')
  })

  register(){
    this.registerService.registerUser(this.registerForm.value).subscribe(response=>{
      alert("Registration successful\nYour user id is "+response.userId);
      this.router.navigateByUrl('/login');
    })
  }


}
