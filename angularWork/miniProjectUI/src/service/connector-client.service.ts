import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from 'src/beans/Client';

@Injectable({
  providedIn: 'root'
})
export class ConnectorClientService {

  constructor(private http : HttpClient) { }

  public insertClient(client:Client) : Observable<Client> {
    const url = `http://localhost:8081/client/insert`;
    return this.http.post<Client>(url, client)
  }

  public getClient(id:number) : Observable<Client> {
    const url = `http://localhost:8081/client/${id}`;
    return this.http.get<Client>(url);
  }

  public updateAgent(id:number, client:Client) : Observable<Client> {
    const url = `http://localhost:8081/client/update/${id}`;
    return this.http.put<Client>(url, client);
  }

  public deleteAgent(id: number) : Observable<Object> {
    const url = `http://localhost:8081/client/delete/${id}`;
    return this.http.delete(url);  
  }
} 
