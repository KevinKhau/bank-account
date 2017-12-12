package bank;

import java.math.BigDecimal;

public class Withdrawal extends Operation {

	public Withdrawal(BigDecimal amount, Account account) {
		super(amount, account);
	}

	@Override
	protected boolean update() {
		if (account.balance.compareTo(amount) == 1) {
			account.balance = account.balance.subtract(amount);
			return true;
		}
		return false;
	}

}
