package entities;

public class CurrentAccount extends Account{

	public CurrentAccount(Client client, Bank bank) {
		super(client, bank);
	}
		

	@Override
	public void printExtract() {
		System.out.println(" ## Extrato Conta Corrente ## ");
		super.printExtract();
	}


}
