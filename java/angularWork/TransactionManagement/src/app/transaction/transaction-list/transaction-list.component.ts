import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Transaction } from 'src/app/transaction';
import { TransactionService } from 'src/app/transaction.service';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

  constructor(private transactionService:TransactionService,private router:Router) { }

  transactions : Transaction[]=[];

  ngOnInit(): void {

    this.getTransaction();
  }

  getTransaction(){
    return this.transactionService.getAllTransaction().subscribe(data=>{
      this.transactions = data;
    },error=>console.log(error));
  }

  

  updateTransaction(TId:any){
    return this.router.navigate(['update-transaction',TId]);
  }

  deleteTransaction(TId:any){
    return this.router.navigate(['delete-transaction',TId]);
  }

}
