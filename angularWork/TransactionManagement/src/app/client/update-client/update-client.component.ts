import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/client';
import { ClientService } from 'src/app/client.service';

@Component({
  selector: 'app-update-client',
  templateUrl: './update-client.component.html',
  styleUrls: ['./update-client.component.css']
})
export class UpdateClientComponent implements OnInit {

  clientId!:number;
  client : Client=new Client();
  constructor(private clientService:ClientService,private route:ActivatedRoute,private router :Router) { }

  ngOnInit(): void {
    this.clientId = this.route.snapshot.params['clientId'];
    this.clientService.getClientById(this.clientId).subscribe(data => {
      this.client = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.clientService.updateClient(this.clientId,this.client).subscribe(data=>{

    },error=>console.log(error));

    this.goToClientList();
  }

  goToClientList(){
    return this.router.navigate(['client/clientlist'])
  }

}
