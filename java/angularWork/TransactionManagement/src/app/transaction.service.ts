import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private httpClient:HttpClient) { }

  getAllTransaction():Observable<Transaction[]>{
    return this.httpClient.get<Transaction[]>('http://localhost:8081/transaction/all');
   }

   createTransaction(transaction:Transaction):Observable<Transaction>{
    return this.httpClient.post<Transaction>('http://localhost:8081/transaction/insert',transaction);
  }
  
  getTransactionById(id:any):Observable<Transaction>{
    return this.httpClient.get<Transaction>('http://localhost:8081/transaction/'+id);
  }
  
  updateTransaction(id:any,transaction:Transaction){
    return this.httpClient.put('http://localhost:8081/transaction/update/'+id, transaction);
  }
  
  deleteTransactionById(id:any):Observable<Transaction>{
    return this.httpClient.delete<Transaction>('http://localhost:8081/transaction/delete/'+id);
  }
}
