package bankingApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	protected Currency CAD, HKD;
	protected Bank TD;
	protected Bank HSBC;
	protected Bank RBC;
	protected Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		
		// setup test currencies
		CAD = new Currency("CAD", 0.75);
		RBC = new Bank("Royal Bank of Canada", CAD);
		
		// setup test accounts
		RBC.openAccount("Peter");
		testAccount = new Account("Albert", CAD);
		testAccount.deposit(new Money(100, CAD));

		// setup an initial deposit
		RBC.deposit("Peter", new Money(500, CAD));
	}

//	@Test
//	public void testAddWithdraw() {
//		// Something to consider - can you withdraw in a different currency?
//		
////		Account withdraw = new Account("Albert", CAD);
////		withdraw.withdraw(new Money(50, CAD));
//	
////		testAccount.withdraw("Peter",new Money(300, CAD));
//		
//		
////		assertEquals(,RBC.withdraw("Peter",new Money(300, CAD)) );
//	}
	
	@Test
	public void testGetBalance(){
		
	 
		System.out.println("balance: "+testAccount);
//		assertEquals(100,actualBalance, 0.01);
//		double expectedBalance = new Money(500, CAD).getAmount();
//		assertEquals(expectedBalance,actualBalance, 0.01);
	}
}
