import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { env } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class RegisterServiceService {
  registerUSer(email: any, password: any, name: any) {
    return this.http.post(
      env.apiUrl + '/api/v1/auth/register',
      {
        email: email,
        password: password,
        name: name,
      },
      { responseType: 'text' }
    );
  }
  constructor(private http: HttpClient) {}
}
