package tests;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.Test;

import bank.Bank;
import bank.Client;

public class LaunchTests {

	Bank axileo = new Bank("Axileo");
	Client julien = new Client("Julien");
	Client charles = new Client("Charles");
	
	public LaunchTests() {
		axileo.openAccount(julien, new BigDecimal("5E+3"), 8495);
		axileo.openAccount(charles, new BigDecimal(3582.16), 4565);
	}

	@Test
	public void test() {
		Currency currency = Currency.getInstance(Locale.FRANCE);
		System.out.println(currency.getDisplayName());
	}
	
	@Test
	public void launchTest() {
		axileo.accounts.parallelStream().forEach(a -> System.out.println(a));
		System.out.println("Fonds de " + axileo.name + " : " + axileo.getBalance().floatValue());
		
		
	}

}
