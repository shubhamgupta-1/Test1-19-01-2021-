package Question2;

public class CurrentAccount extends Account{
	private final float minimumBalance;

	public CurrentAccount() {
		minimumBalance = 5000;
	}
	
	public CurrentAccount(Owner owner, float balance, String nic, float minimumBalance) {
		super(owner, balance,nic);
		this.minimumBalance = minimumBalance;
	}
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CurrentAccount [minimumBalance=").append(minimumBalance).append("]");
		return builder.toString();
	}
	
	public void print() {
		super.print();
		System.out.println(toString());
	}

	public float getCharges() {
		float rate = 2;
		return getBalance()*rate/100;
	}
}
