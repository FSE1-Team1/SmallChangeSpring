package com.fidelity.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Account {
	private String accountNumber;
	private List<Holding> holdings;
	private int maxAccounts;

	public Account(String accountNumber, int maxAccounts) {
		if(accountNumber== null || accountNumber.length()<1) {
			throw new NullPointerException("Account Number cannot be empty.");
		}
		this.accountNumber =accountNumber;
		this.holdings=new ArrayList<Holding>();
		this.maxAccounts=maxAccounts;
	}

	public List<Object> getAccountDetails() {
		return Arrays.asList(accountNumber,holdings);
	}

	public int addHolding(Holding holding) {
		if(holding==null) {
			throw new NullPointerException("Holding cannot be empty.");
		}
		if(holdings.size()>=maxAccounts) {
			throw new IllegalArgumentException("Max Accounts Limit Reached.");
		}
		holdings.add(holding);
		return holdings.size();
	}

	public int removeHolding(Holding holding) {
		if(holding==null)
		{
			throw new NullPointerException("Field can't be blank.");
		}

		for(Holding holding2 : holdings)
		{
			if(holding2 == holding)
			{
				holdings.remove(holding);
				return holdings.size();
			}
		}
		throw new IllegalArgumentException("Holding not found.");
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	

}
