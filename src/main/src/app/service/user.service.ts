import { Component, inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserType } from '../models/user.model';


@Injectable({providedIn:"root"})
export class UserService {

  private httpClient = inject(HttpClient);
  private url = 'http://localhost:8165/users';
  
   constructor(private http: HttpClient) {}

   public createNewUser($user: UserType) {
    return this.httpClient.post(this.url, $user);

   }

   public getAllUsers() {
  return this.httpClient.get(this.url);

   }

   public updateUser($user: UserType) {

    return this.httpClient.put(this.url, $user);

}

public removeUser($id: number) {

  return this.httpClient.delete(`${this.url}/${$id}`);
  
}

}