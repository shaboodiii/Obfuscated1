package com.travelcard.core;

public class TravelCard {
	
	
	private int b;
	
	
	private boolean isCInStatus;
	
	
	private String userID;

	
	public TravelCard() {
	}

	
	
	
	
	public TravelCard(int tcBal) {
		this.b = tcBal;
	}

	
	
	
	
	public TravelCard(String userIDnum) {
		this.userID = userIDnum;
	}

	
	
	
	
	public TravelCard(String userID, int b, boolean isCInStatus) {
		this.userID = userID;
		this.b = b;
		this.isCInStatus = isCInStatus;
	}

	
	
	
	
	public void addBalance(int a) {
		this.b += a;
	}

	
	
	
	
	public int getBalance() {
		return b;
	}

	
	
	
	
	public String getUserID() {
		return userID;
	}

	
	
	
	
	public boolean isCInStatus() {
		return isCInStatus;
	}

	
	
	
	
	public void setBalance(int b) {
		this.b = b;
	}

	
	
	
	
	public void setCheckedInStatus(boolean isCInStatus) {
		this.isCInStatus = isCInStatus;
	}

	
	
	
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	
	
	
	
}
