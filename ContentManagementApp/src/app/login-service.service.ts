import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private httpClient:HttpClient) { }

  url:string="http://localhost:4444/loginapp/v2/login"

  loginUser(data:any):Observable<any>{
    return this.httpClient.post<any>(this.url,data).pipe(catchError(this.handleError));
  }

  handleError(error: { message: any; }){
    return throwError(error.message || "Server Error");
  }

  isLoggedIn:boolean=false

  userLoggedIn(){
    this.isLoggedIn=true;
    console.log(this.isLoggedIn)
  }


}
