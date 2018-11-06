package com.travelcard.core;

public class Station {

	
	private CheckInAutomaton cIn;
	
	
	private CheckOutAutomaton cOut;
	
	
	private int countCIn;
	
	
	private int countCOut;
	
	
	private Kiosk kiosk;

	
	private String sName;

	
	public Station(String stationName) {
		super();
		this.sName = stationName;
	}

	
	
	
	
	public CheckInAutomaton getIn() {
		return cIn;
	}

	
	
	
	
	public CheckOutAutomaton getOut() {
		return cOut;
	}

	
	
	
	
	public int getCountCIn() {
		return countCIn;
	}

	
	
	
	
	public int getCountCOut() {
		return countCOut;
	}

	
	
	
	
	public Kiosk getKiosk() {
		return kiosk;
	}

	
	
	
	
	public String getName() {
		return sName;
	}

	
	
	
	
	public void setCheckIn(CheckInAutomaton cIn) {
		this.cIn = cIn;
	}

	
	
	
	
	public void setCheckOut(CheckOutAutomaton cOut) {
		this.cOut = cOut;
	}

	
	
	
	
	public void setCountCheckIn(int countCIn) {
		this.countCIn = countCIn;
	}

	
	
	
	
	public void setCountCheckOut(int countCOut) {
		this.countCOut = countCOut;
	}

	
	
	
	
	public void setKiosk(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	
	
	
	
	public void setStationName(String sName) {
		this.sName = sName;
	}
	
	
	
	
}
