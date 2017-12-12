package tests;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import bank.Account;
import bank.Bank;
import bank.Client;

public class LaunchTests {

	BigDecimal firstBalance = new BigDecimal(5000);
	BigDecimal secondBalance = new BigDecimal(3515.46);
	
	Bank axileo = new Bank("Axileo");
	Client julien = new Client("Julien");
	Client charles = new Client("Charles");
	Account first = new Account(julien, firstBalance, 8495);
	Account second = new Account(charles, secondBalance, 4565);

	public LaunchTests() {
		axileo.openAccount(first);
		axileo.openAccount(second);
	}

//	@Test
	public void randomTests() {
		Currency currency = Currency.getInstance(Locale.FRANCE);
		System.out.println(currency.getDisplayName());
	}

//	@Test
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

}
