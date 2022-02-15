package education.java.Bank;

public class BankAccount {

	// Сумма на счету
	private double balance;
	private int mainCounter;
	private double maxTransaction;
	private double minTransaction;

	public BankAccount() {
		balance = 0;
	}
	
	// зачислить указанную сумму на счет 
	public void deposit(double amount) {
		balance += amount;
		incrementer();
		minBalance(amount);
		maxBalance(amount);
	}
	
	// снять указанную сумму со счета
	public boolean withdraw(double amount) {
		incrementer();
		if (balance >= amount){
			balance -= amount;
			maxBalance(amount);
			minBalance(amount);
			return true;
		}
		else return false;
	}

	// получить текущйи остаток по счету
	public double getBalance() {
		incrementer();
		return balance;
	}

	private void incrementer(){
		mainCounter += 1;
	}

	public int getCounterTransaction(){
		return mainCounter;
	}

	public void transfer(BankAccount account, double sumTransfer){
		if (account.getBalance() >= sumTransfer){
			account.withdraw(sumTransfer);
			deposit(sumTransfer);
			maxBalance(sumTransfer);
			minBalance(sumTransfer);
		}
	}

	private void maxBalance(double balance){
		if (this.maxTransaction < balance){
			this.maxTransaction = balance;
		}
	}

	private void minBalance(double balance){
		if (this.minTransaction > balance){
			this.minTransaction = balance;
		}
	}

	public double getLargestOperation(){
		return maxTransaction;
	}

	public double getSmallestOperation(){
		return minTransaction;
	}
}
