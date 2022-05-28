import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterServiceService {

  constructor(private httpClient:HttpClient) { }

  url:string="http://localhost:4444/loginapp/v2/register"

  registerUser(data:any){
    return this.httpClient.post<any>(this.url,data);
  }

}
