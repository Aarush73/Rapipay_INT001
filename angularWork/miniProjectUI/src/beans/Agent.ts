export class Agent {
    agentId!: number;
	agentName!:String;
	agentState!:String;
	bankName!:String;
	accountNumber!:number;
	phoneNumber!:number;
	walletBalance!:number;

	public Agent(agentId: number, agentName:String, agentState:String, bankName:String, accountNumber:number, phoneNumber:number, walletBalance:number) {
		this.accountNumber = accountNumber;
		this.agentId = agentId;
		this.agentName = agentName; 
		this.agentState = agentState;
		this.bankName = bankName;
		this.phoneNumber = phoneNumber; 
		this.walletBalance = walletBalance;
	}
}