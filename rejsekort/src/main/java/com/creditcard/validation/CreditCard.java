package com.creditcard.validation;

public class CreditCard {

	
	private int b;
	
	
	private CreditCardCompany cardT;

	
	private int charged;
	
	
	private String ccNumber;
	
	
	private boolean chargedSucces;
	
	
	private boolean valid;

	
	public CreditCard(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	
	
	
	
	public void charge(int a) {
		this.setCharged(a);
		if (getServiceCCBalance() - a >= 0) {
			setChargedSucces(true);
		} else
			setChargedSucces(false);
	}

	
	
	
	
	public int getBalance() {
		return this.b;

	}

	
	
	
	
	public CreditCardCompany getCardType() {
		return cardT;
	}

	
	
	
	
	public int getChargedAmount() {
		return this.charged;
	}

	
	
	
	
	public String getCreditCardNumber() {
		return ccNumber;
	}

	
	
	
	
	public boolean isSuccessfullyCharged() {
		return chargedSucces;
	}

	
	
	
	
	public boolean isValid() {
		return valid;
	}

	
	
	
	
	public void setBalance(int a) {
		this.b = a;

	}

	
	
	
	
	public void setCardT(CreditCardCompany cardT) {
		this.cardT = cardT;
	}
	
	
	
	

	public void setCharged(int charged) {
		this.charged = charged;
	}

	
	
	
	
	public void setCCNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	
	
	
	
	public void setChargedSucces(boolean chargedSucces) {
		this.chargedSucces = chargedSucces;
	}

	
	
	
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	
	
	
	
	private int getServiceCCBalance() {
		return this.b;
	}

}
