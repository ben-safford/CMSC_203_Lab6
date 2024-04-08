
public class SavingsAccount extends BankAccount {
	double rate = 2.5;
	int savingsNumber = 0;
	String accountNumber;
	
	public SavingsAccount(String name, double initialAmt) {
		super(name, initialAmt);
		this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public SavingsAccount(SavingsAccount account, double initialAmt) {
		super(account.getOwner(), initialAmt);
		//convoluted logic here, but I think it's valid - I'm concerned about edge cases involving account numbers with multiple hyphens
		numberOfAccounts--;
		
		String lastNum = account.getAccountNumber();
		String[] numDivisions = lastNum.split("-");
		int lastSavingsNum = Integer.parseInt(numDivisions[numDivisions.length - 1]);
		lastSavingsNum++;
		this.savingsNumber = lastSavingsNum;
		
		this.accountNumber = "";
		for(int i = 0; i < (numDivisions.length - 1); i++)
			this.accountNumber += numDivisions[i] + "-";
		this.accountNumber += lastSavingsNum;
	}
	
	public void postInterest() {
		double monthlyRate = (rate * 0.01) / 12.0;
		this.deposit(this.getBalance() * monthlyRate);
	}
	
	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}
}
