package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;

public class CurrencyTest {
	
	/* Example currencies: 
	 * 	CAD = Canadian dollar
	 * 	EUR = Euros
	 * 	GBP = Great British Pounds
	 * 	HKD = Hong Kong Dollars
	 */
	
 	public Currency CAD, EUR, GBP, HKD;
	
	@Before
	public void setUp() throws Exception {
		// Setup some test currencies to use in the below test cases
		CAD = new Currency("CAD", 0.75);
		EUR = new Currency("EUR", 1.14);
		HKD = new Currency("HKD", 0.13);
	}


	@Test
	public void testGetName() {
		// Write the test case for testing the getName() function
		
		assertEquals("CAD",CAD.getName());
	}
	
	@Test
	public void testGetRate() {
		// @TODO: Write the test case for testing the getRate() function
		
		assertEquals(0.75,CAD.getRate(),0.01);
		
	}
	
	// ==================================
	// 1. Test for the old rate 
	// 2. Set the new rate
	// 3. Test for the new rate
	// ==================================

	@Test
	public void testSetRate() {
		// @TODO: Write the test case for testing the setRate() function
		
		// For this function, you should do:
		
		// 1. Assert that the oldRate is correct
		
		assertEquals(0.75,CAD.getRate(),0.01);
		
		// TODO : Try with negative values
		
		// 2. Change the rate
		CAD.setRate(0.80);
	
		// 3. Assert that the newRate is correct
		assertEquals(0.80,CAD.getRate(),0.01);
		
		// You will end up with 2 assert() statements in this function.
			
		
	}
	
	@Test
	public void testValueInUSD() {
		// @TODO: Write the test case for testing the valueInUSD() function
		
		assertEquals(75,CAD.valueInUSD(100),0.01);
		
		// TODO : Values less or equal 0
	}
	
	@Test
	public void testValueInThisCurrency() {
		
		// @TODO: Write the test case for testing the valueInThisCurrency() function
		
		// For this function, you should:
		
		// 1. Assert the value of the "other" currency
//		Currency curEUR = new Currency("EUR",1.14);
//		double rateEUR = curEUR.getRate();
//		assertEquals(1.14,rateEUR,0.01);
//		
//		// 2. Get the value in "this" currency
//	
//		// 3. Assert that the value in "this" currency is correct
//		// You will end up with 2 assert() statements in this function.
//		double thisCurrencyValue = curCAD.valueInThisCurrency(10, curEUR);
		
		
		
//		assertEquals(15.2,CAD.valueInThisCurrency(10, EUR),0.01);

		// TODO : Should not accept values less or equal 0
		
		assertEquals(1.14,EUR.valueInThisCurrency(10, HKD),0.01);
		
		
			
			
		// 10 HKD = 1.3 USD
		// 1USD - 1.14 EUR
		// 1.3 - ?
//	//	assertEquals(6.57,EUR.valueInThisCurrency(10, CAD),0.01);
		
		
	}

}
