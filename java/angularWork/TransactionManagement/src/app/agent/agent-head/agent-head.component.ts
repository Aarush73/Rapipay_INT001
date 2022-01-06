import { Component, NgModule, OnInit } from '@angular/core';
import { Agent } from 'src/app/agent';
import { AgentService } from 'src/app/agent.service';

// @NgModule({
//   declarations: []
// })
@Component({
  selector: 'app-agent-head',
  templateUrl: './agent-head.component.html',
  styleUrls: ['./agent-head.component.css'],  
})
export class AgentHeadComponent implements OnInit {

  constructor(private agentService:AgentService) { }

  ngOnInit(): void {
  }

  flag = true;
  hideAgent(){
    this.flag=true;
  }

  agent : Agent=new Agent();
  isAgentPresent = false;
  showAgent(agentId:any){

    this.agentService.getAgentById(agentId).subscribe(data=>{
      this.agent = data;
    }, (error)=>console.log(error));
   this.isAgentPresent=true;
     
   }

}
