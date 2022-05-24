package application;

import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.Bank;
import entities.Client;
import entities.CurrentAccount;
import entities.SavingAccount;
import exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		
		Bank bank = new Bank();
		bank.setName("Ligth Bank");
		Client client = new Client();
		client.setName("Sérgio");
		client.setCpf("12345678909");
		
		List<Account> accounts = new ArrayList<>();
		Account currentAccount = new CurrentAccount(client, bank);
		Account savingAccount = new SavingAccount(client,bank);
		accounts.add(currentAccount);
		accounts.add(savingAccount);
		
		bank.setAccounts(accounts);
		
		Bank bank2 = new Bank();
		bank2.setName("Dark Bank");
		
		accounts = new ArrayList<>();
		Account currentAccount2 = new CurrentAccount(client,bank2);
		Account savingAccount2 = new SavingAccount(client,bank2);
		
		accounts.add(currentAccount2);
		accounts.add(savingAccount2);
		
		bank2.setAccounts(accounts);
		
		savingAccount.deposit(1000.0);
		savingAccount2.deposit(500.0);
		
		try {
			savingAccount.withdraw(100.0);
			savingAccount.transfer(250.0, currentAccount2);
			currentAccount2.transfer(200.0, currentAccount);
			currentAccount.transfer(150.0, savingAccount);
		} catch (DomainException e) {
			throw new DomainException(e.getMessage());
		}
		savingAccount.printExtract();
		currentAccount.printExtract();
		savingAccount2.printExtract();
		currentAccount2.printExtract();
		
		
	}


}
