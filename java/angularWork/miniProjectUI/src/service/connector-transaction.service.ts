import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Transaction } from 'src/beans/Transaction';

@Injectable({
  providedIn: 'root'
})
export class ConnectorTransactionService {

  constructor(private http:HttpClient) { }

  public insertAgent(tx:Transaction) : Observable<Object>{
    const url = `http://localhost:8081/transaction/insert`;
    return this.http.post(url, tx, {responseType: 'text'});
  }

  public getAgent(id:number) : Observable<Transaction>{
    const url = `http://localhost:8081/transaction/${id}`;
    return this.http.get<Transaction>(url);
  }

  public updateAgent(id:number, tx:Transaction) : Observable<Transaction> {
    const url = `http://localhost:8081/transaction/update/${id}`;
    return this.http.put<Transaction>(url, tx);
  }

  public deleteAgent(id: number) : Observable<Object> {
    const url = `http://localhost:8081/transaction/delete/${id}`;
    return this.http.delete(url);
  }
}

