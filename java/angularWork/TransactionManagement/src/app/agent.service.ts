import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Agent } from './agent';

@Injectable({
  providedIn: 'root'
})
export class AgentService {

  constructor(private httpClient: HttpClient) { }


  getAllAgent(): Observable<Agent[]> {
    return this.httpClient.get<Agent[]>('http://localhost:8081/agent/all');
  }

  createAgent(agent: Agent): Observable<Agent> {
    return this.httpClient.post<Agent>('http://localhost:8081/agent/insert', agent);
  }

  getAgentById(id: any): Observable<Agent> {
    return this.httpClient.get<Agent>('http://localhost:8081/agent/' + id);
  }

  updateAgent(id: any, agent: Agent) : Observable<Agent> {
    return this.httpClient.put<Agent>('http://localhost:8081/agent/update/' + id, agent);
  }

  deleteAgentById(id: any): Observable<Agent> {
    return this.httpClient.delete<Agent>('http://localhost:8081/agent/delete/' + id);
  }
}
