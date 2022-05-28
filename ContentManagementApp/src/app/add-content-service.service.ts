import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddContentServiceService {

  constructor(private httpClient:HttpClient) { }

  url:string="http://localhost:4444/contapp/v1/content"


  token:string=''

  reqHeader:any;
  

  getAllContent(){
    this.token=localStorage.getItem('Jwt_Token')||''
    console.log(this.token)
    this.reqHeader=new HttpHeaders().set('Authorization','Bearer '+this.token).set('access-control-allow-origin', '*');
    return this.httpClient.get<any>(this.url,{headers:this.reqHeader}).pipe(catchError(this.handleError));
  }

  handleError(error: { message: any; }){
    return throwError(error.message || "Server Error");
  }

  addContent(data:any){
    this.token=localStorage.getItem('Jwt_Token')||''
    console.log(this.token)
    this.reqHeader=new HttpHeaders().set('Authorization','Bearer '+this.token).set('access-control-allow-origin', '*');
    return this.httpClient.post<any>(this.url,data,{headers:this.reqHeader}).pipe(catchError(this.handleError));
  }



}
