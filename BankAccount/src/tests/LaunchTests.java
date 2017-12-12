package tests;

import static org.junit.Assert.*;

import java.util.Currency;
import java.util.Locale;

import org.junit.Test;

import bank.Operation;

public class LaunchTests {

	
	@Test
	public void print() {
		Currency currency = Currency.getInstance(Locale.FRANCE);
		System.out.println(currency.getDisplayName());
	}

}
