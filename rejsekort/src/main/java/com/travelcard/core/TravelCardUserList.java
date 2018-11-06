package com.travelcard.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.travelcard.datagenerator.util.RandomTravelCardUsers;

public class TravelCardUserList {

	
	private List<TravelCard> u;

	
	public TravelCardUserList() {
		u = new ArrayList<>();
		RandomTravelCardUsers rtcu = new RandomTravelCardUsers();
		u = rtcu.generate(10);

	}

	
	
	
	
	public void addUserID(TravelCard newUserID) {
		u.add(newUserID);

	}

	
	
	
	
	public void generateNameList() {
		PrintWriter w = null;
		try {
			w = new PrintWriter(Constants.REPORT_USER_LIST, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		for (TravelCard u1 : u) {
			w.println(u1.getUserID());

		}
		w.close();

	}

	
	
	
	
	public List<TravelCard> getUserIDs() {
		return u;
	}

	
	
	
	
	public boolean reportExists(String rName) {
		File tmpDir = new File(rName);
		return tmpDir.exists();
	}

	
	
	
	
	public void setIDs(List<TravelCard> u) {
		this.u = u;
	}

	
	
	
	
}
