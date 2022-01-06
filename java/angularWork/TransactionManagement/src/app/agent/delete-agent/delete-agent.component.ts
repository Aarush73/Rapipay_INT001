import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Agent } from 'src/app/agent';
import { AgentService } from 'src/app/agent.service';

@Component({
  selector: 'app-delete-agent',
  templateUrl: './delete-agent.component.html',
  styleUrls: ['./delete-agent.component.css']
})
export class DeleteAgentComponent implements OnInit {

  agentId!:number;
  agent :Agent=new Agent();
  constructor(private agentService:AgentService,private route :ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.agentId = this.route.snapshot.params['agentId'];
    this.agentService.deleteAgentById(this.agentId).subscribe(data=>{
        this.agent = data;
    },error=>console.log(error));
    this.goToAgentList();
  }

  goToAgentList(){
    this.router.navigate(['agent/agentlist'])
  }

}
