package entities;

import exceptions.DomainException;

public abstract class Account implements IAccount{
	
	private static int AGENCY_STANDARD = 1;
	private static int ORDER = 1 ;
	
	protected Bank bank;
	protected String type;
	protected int agency;
	protected int number;
	protected double balance;
	protected Client client;
	
	public Account() {
		
	}
	
	public  Account(Client client, Bank bank) {
		this.agency = AGENCY_STANDARD ;
		this.number = ORDER++ ;
		this.client = client;
		this.bank = bank;
		
	}
	@Override
	public void withdraw(Double value) {
		validateWithdraw(value);
		balance -= value;
	}
	@Override
	public void deposit(Double value) {
		balance += value;
	}
	
	@Override
	public void transfer(Double value, Account destinationAccount) {
		this.withdraw(value);
		destinationAccount.deposit(value);
	}
	public void validateWithdraw(double value) {
		
		if(value > getBalance()) {
			throw new DomainException ("Sem saldo suficiente na conta");
		}
	}
	public void validateTranfer(double value) {
		
		if(value > getBalance()) {
			throw new DomainException ("Sem saldo suficiente na conta");
		}
	}
	
	@Override
	public void printExtract() {
		
		System.out.println(String.format("- Banco: %s", this.bank.getName()));

		System.out.println(String.format("- Titular: %s", this.client.getName()));
		System.out.println( String.format("- CPF: %s", this.client.getCpf()));
		System.out.println(String.format("- Tipo de conta: %s", this.type));
		System.out.println(String.format("- Agência: %d", this.agency));
		System.out.println(String.format("- Número da conta: %d", this.number));
		System.out.println(String.format("- Saldo: %.2f", this.balance));
		System.out.println("#############################");
	}
	
	
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public int getAgency() {
		return agency;
	}

	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	public String getType() {
		return type;
	}

}
