package com.travelcard.core;

public class CheckOutAutomaton {

	
	private int countCOut = 0;
	
	
	private final int FARE = 25;
	
	
	private ResponseObject r;
	
	
	private String sName;

	
	public CheckOutAutomaton(String sName) {
		this.setName(sName);
	}

	
	
	
	
	public ResponseObject cOut(TravelCard c) {
	
		if (c.isCInStatus()) {
			charge(c);
			c.setCheckedInStatus(false);
			r = new ResponseObject(230, Constants.CHECKED_OUT_SUCCESS);

			InitSystem.isl.getLogger()
					.info("CHECKOUT: Automaton at " + sName + " : " + Constants.CHECKED_OUT_SUCCESS);
			InitSystem.isl.printLog();
			countCOut++;

		} else {

			r = new ResponseObject(240, Constants.CHECKED_OUT_FAILURE);
		
		}
		
		return r;
	}

	
	
	
	
	public void outLog() {

		InitSystem.isl.logContains(Constants.CHECKED_OUT_SUCCESS);

	}

	
	
	
	
	public String getName() {
		return sName;
	}

	
	
	
	
	public void setName(String sName) {
		this.sName = sName;
	}

	
	
	
	
	private void charge(TravelCard c) {

		c.setBalance(c.getBalance() - FARE);

	}

	
	
	
}
