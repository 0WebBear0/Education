package education.java.Bank;

public class BankAccountTester {

	public void run() {
		BankAccount account = new BankAccount();
		BankAccount account2 = new BankAccount();
		BankAccount account5 = new BankAccount();
		account.deposit(200);
		account.withdraw(120);
		account2.transfer(account,20);
		account5.transfer(account,20);
		System.out.println("balance: " + account.getBalance());
		System.out.println("balance: " + account2.getBalance());
		System.out.println("balance: " + account5.getBalance());
		System.out.println(account.getCounterTransaction());
		System.out.println("maxTransaction: " + account.getLargestOperation());
		System.out.println("minTransaction: " + account.getSmallestOperation());
	}
	
	public static void main(String[] args) {
		BankAccountTester tester = new BankAccountTester();
		tester.run();
	}

}
