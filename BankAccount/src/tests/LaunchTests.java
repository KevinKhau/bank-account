package tests;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Currency;
import java.util.Locale;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import bank.Account;
import bank.Bank;
import bank.Client;
import bank.Operation;

public class LaunchTests {

	BigDecimal firstBalance = new BigDecimal(5000);
	BigDecimal secondBalance = new BigDecimal(3515.46);

	Bank axileo = new Bank("Axileo");
	Client julien = new Client("Julien");
	Client charles = new Client("Charles");
	Account first = new Account(julien, firstBalance, 8495);
	Account second = new Account(charles, secondBalance, 4565);
	
	/* Comparator onUse à choisir pour trier les affichages d'historique */
	Comparator<Operation> byAmountDESC = (o1, o2) -> o2.amount.compareTo(o1.amount);
	Comparator<Operation> byAmountASC = (o1, o2) -> o1.amount.compareTo(o2.amount);
	Comparator<Operation> byDateDESC = (o1, o2) -> o2.date.compareTo(o1.date);
	Comparator<Operation> byDateASC = (o1, o2) -> o1.date.compareTo(o2.date);
	Comparator<Operation> byStateDESC = (o1, o2) -> o2.state.compareTo(o1.state);
	Comparator<Operation> byStateASC = (o1, o2) -> o1.state.compareTo(o2.state);
	Comparator<Operation> onUse = byAmountDESC;

	public LaunchTests() {
		axileo.openAccount(first);
		axileo.openAccount(second);
	}

	// @Test
	public void randomTests() {
		Currency currency = Currency.getInstance(Locale.FRANCE);
		System.out.println(currency.getDisplayName());
	}

	// @Test
	public void displayBalances() {
		axileo.accounts.stream().sorted((a1, a2) -> a2.balance.compareTo(a1.balance))
				.forEach(a -> System.out.println(a));
		System.out.println("Fonds de " + axileo.name + " : " + axileo.getBalance().floatValue());
	}

	@Test
	public void testDeposits() {
		BigDecimal firstPlus = new BigDecimal(20);
		BigDecimal secondPlus = new BigDecimal(3000);
		first.deposit(firstPlus);
		second.deposit(secondPlus);
		assertTrue(first.balance.equals(firstBalance.add(firstPlus)));
		assertTrue(second.balance.equals(secondBalance.add(secondPlus)));
	}

	@Test
	public void testWithdrawals() {
		displayBalances();
		BigDecimal excessiveWithdrawal = new BigDecimal(20000);
		first.withdraw(excessiveWithdrawal);
		assertTrue(first.balance.equals(first.balance));
		BigDecimal twenty = new BigDecimal(20);
		first.withdraw(twenty);
		assertTrue(first.balance.equals(firstBalance.subtract(twenty)));
	}

	public void addTransactions() {
		first.withdraw(new BigDecimal(53));
		second.deposit(new BigDecimal(10));
		first.deposit(new BigDecimal(0.19));
		first.withdraw(new BigDecimal(53));
		first.withdraw(new BigDecimal(156161));
		first.deposit(new BigDecimal(1566));
		second.withdraw(new BigDecimal(466));
		first.deposit(new BigDecimal(156500));
		first.withdraw(new BigDecimal(156161));
		first.withdraw(new BigDecimal(553.64));
	}

	@Test
	public void testHistory() {
		System.out.println(first.getBalance().doubleValue());
		addTransactions();
		first.displayHistory(onUse);
		System.out.println("Balance of " + first.client.name + ": " + first.getBalance().doubleValue() + " "
				+ Operation.BASE_CURRENCY);
	}

	@Test
	public void bankHistory() {
		addTransactions();
		axileo.displayHistory(onUse);
	}

}
