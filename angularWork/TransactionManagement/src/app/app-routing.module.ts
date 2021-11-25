import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgentHeadComponent } from './agent/agent-head/agent-head.component';
import { AgentListComponent } from './agent/agent-list/agent-list.component';
import { CreateAgentComponent } from './agent/create-agent/create-agent.component';
import { DeleteAgentComponent } from './agent/delete-agent/delete-agent.component';
import { UpdateAgentComponent } from './agent/update-agent/update-agent.component';
import { AppComponent } from './app.component';
import { ClientHeadComponent } from './client/client-head/client-head.component';
import { ClientListComponent } from './client/client-list/client-list.component';
import { CreateClientComponent } from './client/create-client/create-client.component';
import { DeleteClientComponent } from './client/delete-client/delete-client.component';
import { DoTransactionComponent } from './client/do-transaction/do-transaction.component';
import { UpdateClientComponent } from './client/update-client/update-client.component';
import { CreateTransactionComponent } from './transaction/create-transaction/create-transaction.component';
import { DeleteTransactionComponent } from './transaction/delete-transaction/delete-transaction.component';
import { TransactionHeadComponent } from './transaction/transaction-head/transaction-head.component';
import { TransactionListComponent } from './transaction/transaction-list/transaction-list.component';
import { UpdateTransactionComponent } from './transaction/update-transaction/update-transaction.component';

const routes: Routes = [
  // {path:'',component:AppComponent},
  // {path:'',redirectTo:'',pathMatch:'full'},
  // {path:'agent',component:AgentHeadComponent},
  // {path:'agent/agentlist',component:AgentListComponent}
  {path:'',component:AppComponent},
  {path:'agent',component:AgentHeadComponent},
  {path:'agent/agentlist',component:AgentListComponent},
  {path:'agent/addAgent',component:CreateAgentComponent},
  {path:'update-agent/:agentId',component:UpdateAgentComponent},
  {path:'delete-agent/:agentId',component:DeleteAgentComponent},
  {path:'client',component:ClientHeadComponent},
  {path:'client/clientlist',component:ClientListComponent},
  {path:'client/doTransaction' , component:DoTransactionComponent},
  {path:'client/addClient',component:CreateClientComponent},
  {path:'update-client/:clientId',component:UpdateClientComponent},
  {path:'delete-client/:clientId',component:DeleteClientComponent},
  {path:'transaction',component:TransactionHeadComponent},
  {path:'transaction/transactionlist',component:TransactionListComponent},
  {path:'transaction/addTransaction',component:CreateTransactionComponent},
  {path:'update-transaction/:TId',component:UpdateTransactionComponent},
  {path:'delete-transaction/:TId',component:DeleteTransactionComponent}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
