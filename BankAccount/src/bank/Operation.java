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
	public Date date;
	public BigDecimal amount;
	Account account;
	public String state = "Processing";

	/**
	 * @param amount
	 *            Montant de la transaction
	 * @param account
	 *            Compte client
	 * @param currency
	 *            Devise, à prendre en compte à plus grande échelle. Dans ce
	 *            kata, on impose l'euro pour toutes les transactions
	 */
	public Operation(BigDecimal amount, Account account, Currency currency) {
		this.date = new Date();
		this.amount = amount;
		this.account = account;
		if (!checkCurrency(currency)) {
			throw new UnsupportedOperationException(
					"Not able to handle '" + currency.getDisplayName() + "' operations yet.");
		} else {
			this.currency = currency;
		}
		init();
		if (!called) {
			throw new IllegalStateException("super() not applied from derived class");
		}
		if (update()) {
			state = "SUCCESS";
		} else {
			state = "FAILURE";
			System.err.println(account.client.name + ": " + this.getClass().getSimpleName() + " of " + getAmount() + " "
					+ currency.getSymbol() + ", failure.");
		}
		account.operations.add(this);
	}

	public Operation(BigDecimal amount, Account account) {
		this(amount, account, BASE_CURRENCY);
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
	 * 
	 * @param currency
	 */
	protected boolean checkCurrency(Currency currency) {
		return currency.equals(BASE_CURRENCY);
	}

	public float getAmount() {
		return amount.floatValue();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase() + " [date=" + date + ", amount=" + getAmount() + " "
				+ currency.getDisplayName() + ", state=" + state + "]";
	}

}
