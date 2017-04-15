package com.ntier.bank;

public class Bank {

	// Collaborative object
	private Account account;

	Bank(Account account) {

		this.account = account;
	}

	public String getAccountHoldersName() {
		return account.getName();
	}

	public double getAccountBalance(String currency) {
		return account.getBalance(currency);
	}

	public String closeAccount() {
		account.close();
		return "account closed";
	}

}
