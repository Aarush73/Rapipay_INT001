import { Component } from '@angular/core';
import { Agent } from 'src/beans/Agent';
import { ConnectorAgentService } from 'src/service/connector-agent.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'miniProjectUI';
  constructor(private cas : ConnectorAgentService) {
    
  }

  doThis() {
    var agent : Agent = new Agent();
    this.cas.getAgent(2).subscribe((data)=> {
      agent = data;
      console.log(agent)
    })
  }
}
