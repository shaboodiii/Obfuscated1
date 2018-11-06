package com.travelcard.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SystemLogger {
	
	
	private static Logger log;

	
	private FileHandler fileTxt;
	
	
	private SimpleFormatter formatTxt;

	
	private String logname = "Logfile.txt";

	
	public SystemLogger() {
		this.setLogname("Logfile.txt");
		log = Logger.getLogger("Travel Card Example Logger");
		log.setLevel(Level.ALL);
		setup();
	}

	
	
	
	
	public SystemLogger(String file) {
		this.setLogname(file);
		log = Logger.getLogger("Travel Card Example Logger");
		log.setLevel(Level.ALL);
	}

	
	
	
	
	public boolean exists(String file) {
	
		File tmpDir = new File(file);

		if (tmpDir.exists()) {

			return true;
		}
		return false;
	}

	
	
	
	
	public String getLogname() {
		return logname;
	}

	
	
	
	
	public Logger getLogger() {
		if (log == null) {
			log = Logger.getLogger("Travel Card Example Logger");
			log.setLevel(Level.ALL);
		}
		return log;
	}

	
	
	
	
	public void logContains(String cInSuccess) {
		readlog(cInSuccess);

	}

	
	
	
	
	public void printLog() {
		try {

			if (fileTxt == null) {
				fileTxt = new FileHandler(logname);
			} else {

				// create a TXT formatter
				formatTxt = new SimpleFormatter();
				fileTxt.setFormatter(formatTxt);
				log.addHandler(fileTxt);

			}

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	
	
	
	public boolean readlog(String msg) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(logname));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String strLine;

		/* read log line by line */
		try {
			while ((strLine = br.readLine()) != null) {
				if (strLine.equals(msg)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	
	
	public void setLogname(String logname) {
		this.logname = logname;
	}

	
	
	
	
	public void setup() {
		printLog();

	}

}
