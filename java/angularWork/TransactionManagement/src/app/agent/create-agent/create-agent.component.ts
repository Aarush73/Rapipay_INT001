import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Agent } from 'src/app/agent';
import { AgentService } from 'src/app/agent.service';


@Component({
  selector: 'app-create-agent',
  templateUrl: './create-agent.component.html',
  styleUrls: ['./create-agent.component.css']
})
export class CreateAgentComponent implements OnInit {

  constructor(private agentService:AgentService,private router:Router) { }

  agent :Agent=new Agent();

  ngOnInit(): void {

  }

  onSubmit(){
    this.saveAgent();
  }

  saveAgent(){
    this.agentService.createAgent(this.agent).subscribe(data=>{
      console.log(data);
    },error=>console.log(error));

    this.goToAgentList();
  }

  goToAgentList(){
    return this.router.navigate(['agent/agentlist'])
  }

  backToHome(){
    return this.router.navigate(['../'])
  }

}
