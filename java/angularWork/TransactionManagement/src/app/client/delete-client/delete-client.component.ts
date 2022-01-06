import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/client';
import { ClientService } from 'src/app/client.service';

@Component({
  selector: 'app-delete-client',
  templateUrl: './delete-client.component.html',
  styleUrls: ['./delete-client.component.css']
})
export class DeleteClientComponent implements OnInit {

  clientId!:number;
  agent :Client=new Client();
  constructor(private clientService:ClientService,private route :ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.clientId = this.route.snapshot.params['clientId'];
    this.clientService.deleteClientById(this.clientId).subscribe(data=>{
        this.agent = data;
    },error=>console.log(error));
    this.goToAgentList();
  }

  goToAgentList(){
    this.router.navigate(['client/clientlist'])
  }

}
