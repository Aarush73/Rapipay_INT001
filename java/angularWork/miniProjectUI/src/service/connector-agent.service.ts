import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Agent } from 'src/beans/Agent';

@Injectable({
  providedIn: 'root'
})
export class ConnectorAgentService {

  constructor(private http : HttpClient) { }

  public insertAgent(agent:Agent) : Observable<Object> {
    const url = `http://localhost:8081/agent/insert`;
    return this.http.post(url, agent, {responseType : 'text'})
  }

  public getAgent(id:number) : Observable<Agent> {
    const url = `http://localhost:8081/agent/2`;
    return this.http.get<Agent>(url);
  }

  public updateAgent(id:number, agent:Agent) : Observable<Agent>{
    const url = `http://localhost:8081/agent/update/${id}`;
    return this.http.put<Agent>(url,agent);
  }

  public deleteAgent(id: number) : Observable<Object>{
    const url = `http://localhost:8081/agent/delete/${id}`;
    return this.http.delete(url);
  }
}
