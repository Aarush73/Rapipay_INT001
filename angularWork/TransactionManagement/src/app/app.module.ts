import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAgentComponent } from './agent/create-agent/create-agent.component';
import { AgentListComponent } from './agent/agent-list/agent-list.component';
import { UpdateAgentComponent } from './agent/update-agent/update-agent.component';
import { AgentHeadComponent } from './agent/agent-head/agent-head.component';
import { FormsModule } from '@angular/forms';
import { DeleteAgentComponent } from './agent/delete-agent/delete-agent.component';
import { ClientListComponent } from './client/client-list/client-list.component';
import { ClientHeadComponent } from './client/client-head/client-head.component';
import { DoTransactionComponent } from './client/do-transaction/do-transaction.component';
import { CreateClientComponent } from './client/create-client/create-client.component';
import { UpdateClientComponent } from './client/update-client/update-client.component';
import { DeleteClientComponent } from './client/delete-client/delete-client.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import { TransactionHeadComponent } from './transaction/transaction-head/transaction-head.component';
import { TransactionListComponent } from './transaction/transaction-list/transaction-list.component';
import { CreateTransactionComponent } from './transaction/create-transaction/create-transaction.component';
import { UpdateTransactionComponent } from './transaction/update-transaction/update-transaction.component';
import { DeleteTransactionComponent } from './transaction/delete-transaction/delete-transaction.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateAgentComponent,
    AgentListComponent,
    UpdateAgentComponent,
    AgentHeadComponent,
    DeleteAgentComponent,
    ClientListComponent,
    ClientHeadComponent,
    DoTransactionComponent,
    CreateClientComponent,
    UpdateClientComponent,
    DeleteClientComponent,
    TransactionHeadComponent,
    TransactionListComponent,
    CreateTransactionComponent,
    UpdateTransactionComponent,
    DeleteTransactionComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatIconModule,
    


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
