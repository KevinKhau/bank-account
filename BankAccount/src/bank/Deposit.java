package bank;

import java.math.BigDecimal;

public class Deposit extends Operation {

	public Deposit(BigDecimal amount, Account account) {
		super(amount, account);
	}

	@Override
	protected boolean update() {
		account.balance = account.balance.add(amount);
		return true;
	}

}
