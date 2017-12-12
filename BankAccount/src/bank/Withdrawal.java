package bank;

import java.math.BigDecimal;

public class Withdrawal extends Operation {

	public Withdrawal(BigDecimal amount, Account account, Bank bank) {
		super(amount, account, bank);
	}

	@Override
	protected boolean update() {
		if (account.balance.compareTo(amount) == 1) {
			account.balance.subtract(amount);
			return true;
		}
		return false;
	}

}
