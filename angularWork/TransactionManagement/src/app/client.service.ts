import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from './client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient:HttpClient) { }

  getAllClient():Observable<Client[]>{
    return this.httpClient.get<Client[]>('http://localhost:8081/client/all');
   }

   createClient(client:Client):Observable<Client>{
    return this.httpClient.post<Client>('http://localhost:8081/client/insert',client);
  }
  
  getClientById(id:any):Observable<Client>{
    return this.httpClient.get<Client>('http://localhost:8081/client/'+id);
  }
  
  updateClient(id:any,client:Client){
    return this.httpClient.put('http://localhost:8081/client/update/'+id, client);
  }
  
  deleteClientById(id:any):Observable<Client>{
    return this.httpClient.delete<Client>('http://localhost:8081/client/delete/'+id);
  }
}
