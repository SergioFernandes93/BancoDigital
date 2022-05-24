package entities;

public interface IAccount {
	
	
	void  withdraw(Double value);
	void deposit(Double value);
	void transfer(Double value,Account destdestinationAccount);
	void printExtract();
}
