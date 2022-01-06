export class Transaction {
	tId!: number;
	tDate!: Date;
	agentId!: number;
	clientId!: number;
	tType!: String;
	amount!: number;

	public Transaction(tId: number, tDate: Date, agentId: number, clientId: number, tType: String, amount: number) {
		this.tId = tId;
		this.tDate = tDate;
		this.agentId = agentId;
		this.clientId = clientId;
		this.tType = tType;
		this.amount = amount;

	}
}