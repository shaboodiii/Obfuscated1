package com.travelcard.core;

public class CheckInAutomaton {

	
	private int countCIn = 0;
	
	
	private final int MIN_CIN_B = 25;
	
	
	private ResponseObject r;
	
	
	private String sName;

	
	public CheckInAutomaton(String sName) {
		this.sName = sName;

	}
	
	
	
	

	public ResponseObject cIn(TravelCard c) {
		
		if (!c.isCInStatus()) {
		
			if (enough(c)) {
				c.setCheckedInStatus(true);
				r = new ResponseObject(200, Constants.CHECKED_IN_SUCCESS);

				InitSystem.isl.getLogger()
						.info("CHECKIN: Automaton at " + sName + " : " + Constants.CHECKED_IN_SUCCESS);
				InitSystem.isl.printLog();
				countCIn++;
			
			} else {
			
				r = new ResponseObject(220, Constants.CHECKED_IN_FAILURE_LOW_BALANCE);
			
			}
			
		} else {
			
			r = new ResponseObject(210, Constants.CHECKED_IN_FAILURE_ALREADY);
		
		}
		
		return r;
	}

	
	
	
	
	public void inLog() {
		InitSystem.isl.logContains(Constants.CHECKED_IN_SUCCESS);
	}

	
	
	
	
	public String getName() {
		return sName;
	}

	
	
	
	
	public void setName(String sName) {
		this.sName = sName;
	}

	
	
	
	
	private boolean enough(TravelCard c) {
		return c.getBalance() > MIN_CIN_B;
	}

	
	
	
	
}
