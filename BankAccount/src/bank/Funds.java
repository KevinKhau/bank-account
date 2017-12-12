package bank;

import java.math.BigDecimal;
import java.util.Comparator;

public interface Funds {

	/**
	 * Affiche l'historique
	 * 
	 * @param sorter
	 *            Critère de tri
	 */
	void displayHistory(Comparator<Operation> sorter);

	BigDecimal getBalance();

}
