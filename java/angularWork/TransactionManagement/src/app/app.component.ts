import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Agent } from './agent';
import { AgentService } from './agent.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TransactionManagement';

  constructor(private agentService:AgentService,private route:ActivatedRoute){}

  flag = true;
  hideAgent(){
    this.flag=false;
    console.log("yes");
  }

  hideClient(){
    this.flag=false;
  }

  hideTransaction(){
    this.flag=false;
  }

  agent:Agent=new Agent();
  
  showAgent(agentId:any){

   this.agentService.getAgentById(agentId).subscribe(data=>{
     this.agent = data;
   }, (error)=>console.log(error));
   this.showAgentById()
    
  }

  isAgentPresent = false;
 
  showAgentById(){
    if(this.agent!=null){
      this.isAgentPresent = true;
    }
  }
}
