import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials: { email: string, password: string }) {
    // send a login request to the server
    return this.http.post('/api/login', credentials);
  }

  logout() {
    // send a logout request to the server
    return this.http.post('/api/logout', {});
  }

  isLoggedIn() {
    // check if the user is logged in by sending a request to the server
    // or by checking a value in local storage
    return this.http.get('/api/isLoggedIn');
  }

}
