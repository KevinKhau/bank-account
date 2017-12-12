package bank;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public abstract class Operation {

	public static final Currency BASE_CURRENCY = Currency.getInstance(Locale.FRANCE);
	
	/* Pour s'assurer que super() sera bien utilisé par les classes dérivées */
	private boolean called = false;;
	
	Currency currency;
	Date date;
	BigDecimal amount;
	Account account;
	Bank bank;

	
	public Operation(BigDecimal amount, Account account, Bank bank, Currency currency) {
		this.date = new Date();
		this.amount = amount;
		this.account = account;
		this.bank = bank;
		if (!checkCurrency(currency)) {
			throw new UnsupportedOperationException("Not able to handle '" + currency.getDisplayName() + "' operations yet.");
		}
		init();
		if (!called) {
			throw new IllegalStateException("super() not applied from derived class");
		}
		update();
	}
	
	public Operation(BigDecimal amount, Account account, Bank bank) {
		this(amount, account, bank, BASE_CURRENCY);
	}
	
	private void init() {
		called = true;
	}

	/**
	 * @return true si l'opération réussit
	 */
	protected abstract boolean update();

	/**
	 * Vérifie que la bonne devise est traitée. Pour l'instant, on ne traite que
	 * l'euro
	 * @param currency
	 */
	protected boolean checkCurrency(Currency currency) {
		return currency.equals(BASE_CURRENCY);
	}

}
