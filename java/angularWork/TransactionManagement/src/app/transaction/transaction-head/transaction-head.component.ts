import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-transaction-head',
  templateUrl: './transaction-head.component.html',
  styleUrls: ['./transaction-head.component.css']
})
export class TransactionHeadComponent implements OnInit {

  constructor() { }

  flag = true;
  ngOnInit(): void {
  }

}
