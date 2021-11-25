import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Agent } from 'src/app/agent';
import { AgentService } from 'src/app/agent.service';

@Component({
  selector: 'app-update-agent',
  templateUrl: './update-agent.component.html',
  styleUrls: ['./update-agent.component.css']
})
export class UpdateAgentComponent implements OnInit {

  constructor(private agentService:AgentService,private route:ActivatedRoute,private router :Router) { }

  agent : Agent=new Agent();
  agentId!:number;
  ngOnInit(): void {
    this.agentId = this.route.snapshot.params['agentId'];
    this.agentService.getAgentById(this.agentId).subscribe(data => {
      this.agent = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.agentService.updateAgent(this.agentId, this.agent).subscribe( data =>{
      
    }
    , error => console.log(error));

    this.goToAgentList();
  }

  goToAgentList(){
    return this.router.navigate(['agent/agentlist']);
  }

  backToHome(){
    return this.router.navigate(['../'])
  }

}
