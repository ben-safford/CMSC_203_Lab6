
public class CheckingAccount extends BankAccount {
	final double FEE = 0.15;
	
	public CheckingAccount(String name, double initialAmt) {
		super(name, initialAmt);
		setAccountNumber(getAccountNumber() + "-10");
	}
	
	@Override
	public boolean withdraw(double amt) {
		amt += FEE;
		return super.withdraw(amt);
	}
}
