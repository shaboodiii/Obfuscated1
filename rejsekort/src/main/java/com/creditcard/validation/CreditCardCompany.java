package com.creditcard.validation;

/**
 * enum for card company specifics
 * 
 */
public enum CreditCardCompany {

	AMEX("^3[47][0-9]{13}$", "AMEX"), DINERS("^3(?:0[0-5]|[68][0-9])[0-9]{11}$", "Diners"), DISCOVER(
			"^6(?:011|5[0-9]{2})[0-9]{12}$", "DISCOVER"), JCB("^(?:2131|1800|35\\d{3})\\d{11}$",
					"JCB"), MASTERCARD("^5[1-5][0-9]{14}$", "MASTER"), VISA("^4[0-9]{12}(?:[0-9]{3})?$", "VISA");

	
	
	public static CreditCardCompany getCompany(String c) {
		for (CreditCardCompany cc : CreditCardCompany.values()) {
			if (cc.matches(c)) {
				return cc;
			}
		}
		return null;
	}
	
	
	public static CreditCardCompany getCompanyByName(String name) {
		for (CreditCardCompany cc : CreditCardCompany.values()) {
			if (cc.getName().equals(name)) {
				return cc;
			}
		}
		return null;
	}

	
	
	
	
	private String name;

	
	private String regex;

	
	CreditCardCompany(String regex, String name) {
		this.regex = regex;
		this.name = name;
	}
	
	
	
	

	public String getName() {
		return this.name;
	}
	
	
	
	

	public boolean matches(String c) {
		return c.matches(this.regex);
	}

}
