import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/client';
import { ClientService } from 'src/app/client.service';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {

  client : Client=new Client();
  constructor(private clientService:ClientService,private router :Router) { }

  ngOnInit(): void {
  }

  onSubmit(){

    this.saveClient();
  }

  saveClient(){
     this.clientService.createClient(this.client).subscribe(data=>{
      console.log(data)
    },error=>console.log(error));
    this.goToClientList();

  }

  goToClientList(){
    return this.router.navigate(['client/clientlist'])
  }

  backToHome(){
    return this.router.navigate(['../'])
  }

}
