import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/client';
import { ClientService } from 'src/app/client.service';

@Component({
  selector: 'app-client-head',
  templateUrl: './client-head.component.html',
  styleUrls: ['./client-head.component.css']
})
export class ClientHeadComponent implements OnInit {

  constructor(private clientService:ClientService) { }

  flag =true;
  ngOnInit(): void {
  }

  hideClient(){
    this.flag=false;
  }

  client : Client=new Client();
  showClient(agentId:any){

    this.clientService.getClientById(agentId).subscribe(data=>{
      this.client = data;
    }, (error)=>console.log(error));
    this.showClientById()
     
   }

   isClientPresent = false;
 
  showClientById(){
    if(this.client!=null){
      this.isClientPresent = true;
    }
  }

}
