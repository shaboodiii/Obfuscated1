package com.travelcard.core;

public class ResponseObject {

	
	private int Code;
	
	
	private String sMessage;

	
	private String message;

	public ResponseObject(int Code, String message) {
		super();
		this.Code = Code;
		this.message = message;
	}

	
	
	
	
	public int getCode() {
		return Code;
	}

	
	
	
	
	public String getSMessage() {
		return sMessage;
	}

	
	
	
	
	public String getMessage() {
		return message;
	}

	
	
	
	
	public void setCode(int Code) {
		this.Code = Code;
	}

	
	
	
	
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
}
