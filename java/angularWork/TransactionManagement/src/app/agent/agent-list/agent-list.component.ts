import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Agent } from 'src/app/agent';
import { AgentService } from 'src/app/agent.service';


@Component({
  selector: 'app-agent-list',
  templateUrl: './agent-list.component.html',
  styleUrls: ['./agent-list.component.css']
})
export class AgentListComponent implements OnInit {

 agents:Agent[]=[]
  constructor(private agentService:AgentService,private router:Router) { }

  ngOnInit(): void {
    this.getAgent();
  }

  getAgent(){
    return this.agentService.getAllAgent().subscribe(data=>{
      this.agents=data;
    })

  }

  updateAgent(id:number){
    return this.router.navigate(['/update-agent' , id])
}

deleteAgent(id:number){
  return this.router.navigate(['/delete-agent',id])
}

sortDescWallet(){
  this.agents = this.agents.sort((a,b)=>a.walletBalance-b.walletBalance)
}

sortAsceWallet(){
  this.agents = this.agents.sort((a,b)=>b.walletBalance-a.walletBalance)

}

sortDescState(){
  this.agents = this.agents.sort((a,b)=>a.agentState.localeCompare(b.agentName))
}

sortAsceState(){
  this.agents = this.agents.sort((a,b)=>b.agentState.localeCompare(a.agentState))

}

// agent:Agent=new Agent();
  
// showAgent(agentId:any){

//  this.agentService.getAgentById(agentId).subscribe(data=>{
//    this.agent = data;
//  }, (error)=>console.log(error));
//  this.showAgentById()
  
// }

// isAgentPresent = false;

// showAgentById(){
//   if(this.agent!=null){
//     this.isAgentPresent = true;
//   }
// }

}
