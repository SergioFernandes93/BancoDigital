package entities;

public class SavingAccount extends Account {

	public SavingAccount(Client client, Bank bank) {
		super(client,bank);
	}

	@Override
	public void printExtract() {
		System.out.println(" ## Extrato Conta Poupança ## ");
		super.printExtract();

	}

}
