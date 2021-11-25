import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/client';
import { ClientService } from 'src/app/client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  constructor(private clientService:ClientService,private router:Router) { }

  clients : Client[] = [];

  ngOnInit(): void {
    this.getClient();
  }

  getClient(){
    return this.clientService.getAllClient().subscribe(data=>{
      this.clients=data;
    })
  }

  updateClient(clientId:any){
    return this.router.navigate(['update-client',clientId]);
  }

  deleteClient(clientId:any){
    return this.router.navigate(['delete-client',clientId])
  }

  sortDescWallet(){
    this.clients = this.clients.sort((a,b)=>a.walletBalance-b.walletBalance)
  
  }

  sortAsceWallet(){
    this.clients = this.clients.sort((a,b)=>b.walletBalance-a.walletBalance)
  
  }
  
  sortDescState(){
    this.clients = this.clients.sort((a,b)=>a.clientState.localeCompare(b.clientState))
  }
  
  sortAsceState(){
    this.clients = this.clients.sort((a,b)=>b.clientState.localeCompare(a.clientState))
  
  }

}
