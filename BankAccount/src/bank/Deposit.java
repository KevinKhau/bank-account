package bank;

import java.math.BigDecimal;

public class Deposit extends Operation {

	public Deposit(BigDecimal amount, Account account) {
		super(amount, account);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean update() {
		account.balance.add(amount);
		return true;
	}

}
