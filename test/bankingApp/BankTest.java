package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.AccountDoesNotExistException;
import bankingApp.AccountExistsException;
import bankingApp.Bank;
import bankingApp.Currency;

public class BankTest {
	protected Currency CAD;
	protected Currency HKD;
	protected Bank RBC;
	protected Bank TD;
	protected Bank HSBC;

	@Before
	public void setUp() throws Exception {

		// setup some test currencies
		this.HKD = new Currency("HKD", 0.13);
		this.CAD = new Currency("CAD", 0.75);

		// setup test banks
		this.RBC = new Bank("Royal Bank of Canada", CAD);
		this.TD = new Bank("TD Bank", CAD);
		this.HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);

		// add sample customers to the banks

		// HINT: uncomment these lines AFTER you test the openAccount() function
		// You can quickly uncomment / comment by highlighting the lines of code and
		// pressing
		// CTRL + / on your keyboard (or CMD + / for Macs)

		this.RBC.openAccount("Marcos");
		this.RBC.openAccount("Albert");
		this.TD.openAccount("Jigesha");
		this.HSBC.openAccount("Pritesh");
	}

	@Test
	public void testGetName() {

		String getName = this.TD.getName();
		assertEquals("TD Bank", getName);

	}

	@Test
	public void testGetCurrency() {
		Currency getCurrencyOfBank = this.TD.getCurrency();
		assertEquals(CAD, getCurrencyOfBank);

	}

	/**
	 * BUG: does not throw error for AccountExistsException
	 * 
	 * @throws AccountExistsException
	 * @throws AccountDoesNotExistException
	 */
	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.

		this.RBC.openAccount("Albert");

	}

	/**
	 * BUG: does not throw AccountDoesNotExistException BUG: does not work properly
	 * for existing account
	 * 
	 * @throws AccountDoesNotExistException
	 */
	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.

		this.TD.deposit("Albert", new Money(100, CAD));

		this.TD.deposit("shivam", new Money(100000000, CAD));

	}

	/**
	 * BUG: ask for clarification
	 * 
	 * @throws AccountDoesNotExistException
	 */
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.

		// See the example in class notes for testing exceptions.

		TD.withdraw("sachin", new Money(100, CAD));
	}

	/**
	 * BUG: ask for clarification
	 * 
	 * @throws AccountDoesNotExistException
	 */
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.

		// See the example in class notes for testing exceptions.
		TD.getBalance("John");
	}

	/**
	 * BUG: ask for clarification
	 * 
	 * @throws AccountDoesNotExistException
	 * @throws NotSufficientMoney 
	 */
	@Test
	public void testTransfer() throws AccountDoesNotExistException, NotSufficientMoney {
		// Note: You should test both types of transfers:
		// 1. Transfer from account to account
		RBC.transfer("Marcos", "Albert", new Money(100, CAD));
		// 2. Transfer between banks
		TD.transfer("Albert", RBC, "Marcos", new Money(100, CAD));
		// See the Bank.java file for more details on Transfers
	}

}
