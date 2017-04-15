package com.ntier.bank;


import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	
	//	Business objects under test
	private Bank bank;
	private Account account;
	
	@Before
	public void setup(){
		//	Create mock object
		account = EasyMock.createMock(Account.class);
		//	Feed account to bank
		bank = new Bank(account);
	}
	
	@Test
	public void testGetAccountHoldersName(){
		//	Record methods call
		EasyMock.expect(account.getName()).andReturn("Joe Jones");
		//	Get account ready to handle getName test
		EasyMock.replay(account);
		//	Test method
		String expected = "Joe Jones";
		String actual = bank.getAccountHoldersName();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetAccountBalance() {
		//	Record method call
		EasyMock.expect(account.getBalance("USD")).andReturn(100.00);
		//	Get account ready to handle getName test
		EasyMock.replay(account);
		//	Test method
		double expected = 100.00;
		double actual = bank.getAccountBalance("USD");
		assertEquals(expected, actual, 001);
	}
	
	@Test
	public void testClose(){
		//	Record method call
		account.close();
		//	Get account ready to handle getName test
		EasyMock.replay(account);
		//	Test method
		String expected = "account closed";
		String actual = bank.closeAccount();
		assertEquals(expected, actual);
		EasyMock.verify(account);
	}

}
