package com.travelcard.core;

import java.util.ArrayList;
import java.util.List;
import com.creditcard.validation.CreditCard;
import com.creditcard.validation.CreditCardCompany;

public class Kiosk {

	private static boolean check(String cNumber) {
		int d = cNumber.length();
		int oddOrEven = d & 1;
		long sum = 0;
		for (int i = 0; i < d; i++) {
			int d1 = 0;
			try {
				d1 = Integer.parseInt(cNumber.charAt(i) + "");
			} catch (NumberFormatException e) {
				return false;
			}

			if (((i & 1) ^ oddOrEven) == 0) { // not
				d1 *= 2;
				if (d1 > 9) {
					d1 -= 9;
				}
			}
			sum += d1;
		}

		return (sum == 0) ? false : (sum % 10 == 0);
	}

	
	
	
	
	private final int FARE_TRAVEL_CARD_CREATION = 100;

	
	private CreditCard cc;
	
	
	private ResponseObject r;
	
	
	private String sName;
	
	
	private List<TravelCard> tcUsers;

	
	private String text;

	
	public Kiosk(String sName) {
		this.setName(sName);
		tcUsers = new ArrayList<TravelCard>();
		TravelCardUserList tcu = new TravelCardUserList();
		tcUsers = tcu.getUserIDs();
	}

	
	
	
	
	public ResponseObject addBalance(TravelCard tcInUse, int amount) {
	
		if (verify(cc).getCode() == 530) {
			
			cc.charge(amount);
		
			if (cc.isSuccessfullyCharged()) {
			
				r = new ResponseObject(300, Constants.RELOAD_SUCCESS);
				tcInUse.addBalance(amount);
				InitSystem.isl.getLogger().info("CREDIT CARD :" + Constants.VALID_CC + Constants.RELOAD_SUCCESS);
				InitSystem.isl.printLog();
			
			} else {
			
				r = new ResponseObject(320, Constants.INVALID_CC_LOW_BALANCE);
			
			}
		
		}
		
		return r;

	}

	
	
	
	public void cRegistered() {
		InitSystem.isl.logContains(Constants.VALID_CC + Constants.TRAVEL_CARD_CREATION_SUCCESS);

	}

	
	
	
	
	public void cReload() {
		InitSystem.isl.logContains(Constants.VALID_CC + Constants.RELOAD_SUCCESS);

	}

	
	
	
	
	public CreditCard getCC() {
		return cc;
	}

	
	
	
	
	public String getName() {
		return sName;
	}

	
	
	
	
	public List<TravelCard> getUsers() {
		return tcUsers;
	}

	
	
	
	
	public String getTextOnScreen() {
		return text;
	}

	
	
	
	
	public ResponseObject createTC(TravelCard u) {

		if (!tcUsers.contains(u)) {
	
			cc.charge(FARE_TRAVEL_CARD_CREATION);
			
			if (cc.isSuccessfullyCharged()) {

				tcUsers.add(u);
				r = new ResponseObject(400, Constants.TRAVEL_CARD_CREATION_SUCCESS);
				InitSystem.isl.getLogger()
						.info("CREDIT CARD :" + Constants.VALID_CC + Constants.TRAVEL_CARD_CREATION_SUCCESS);
				InitSystem.isl.printLog();

			} else {
			
				r = new ResponseObject(420, Constants.INVALID_CC_LOW_BALANCE);
			
			}

		} else{
		
			r = new ResponseObject(410, Constants.TRAVEL_CARD_CREATION_FAILURE);
		
		}
		
		return r;
	
	}

	
	
	
	
	public void setCC(CreditCard cc) {
		this.cc = cc;
	}

	
	
	
	
	public void setName(String sName) {
		this.sName = sName;
	}

	
	
	
	
	public void setUsers(List<TravelCard> tcUsers) {
		this.tcUsers = tcUsers;
	}

	
	
	
	
	public void setTextOnScreen(String text) {
		this.text = text;
	}

	
	
	
	
	public ResponseObject verify(CreditCard cc) {
	
		String cn = cc.getCreditCardNumber().replaceAll("[^0-9]+", "");
		
		if ((cn == null) || (cn.length() < 13) || (cn.length() > 19)) {
		
			this.text = Constants.INVALID_CC_LENGTH;

			return new ResponseObject(500, Constants.INVALID_CC_LENGTH);
		
		}

		if (!check(cn)) {
	
			this.text = Constants.INVALID_CC_LETTERS;
		
			return new ResponseObject(510, Constants.INVALID_CC_LETTERS);
		
		}

		CreditCardCompany ccc = CreditCardCompany.getCompany(cn);
		
		if (ccc == null) {
		
			this.text = Constants.INVALID_CC_COMPANY;

			return new ResponseObject(520, Constants.INVALID_CC_COMPANY);
		
		}

		this.text = Constants.VALID_CC;
		setCC(cc);

		return new ResponseObject(530, Constants.VALID_CC);

	}

}
