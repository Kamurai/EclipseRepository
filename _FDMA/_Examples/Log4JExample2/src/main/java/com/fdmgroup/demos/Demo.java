package com.fdmgroup.demos;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class Demo {

	// Initialize a logger. Here, we create the root logger 
	// (sometimes ill-advised, better to use a specific logger):
	//
	// static Logger rootLog = Logger.getRootLogger();
	
	
	// Or, get specific loggers to direct logging output
	// to well-defined locations:
	
	// The programmer can send the bulk of logging output here
	private static Logger programmerLog = Logger.getLogger("programmerLog");
	
	// If you really insist on seeing console output, use this for 
	// console output:
	private static Logger consoleLog = Logger.getLogger("consoleLog");
	
	// Management and audit logs can go here
	private static Logger managerLog = Logger.getLogger("managerLog");

	public static void main(String[] args) {
		
		// Start by configuring your loggers:
		
		// Option A -- All loggers send DEBUG and above to console
		BasicConfigurator.configure(); 
		
		// Option B -- Configured according to .properties file
		// PropertyConfigurator.configure("src/main/resources/full-config.properties");

		// Option C -- Configured according to .xml file
		// DOMConfigurator.configure("src/main/resources/root-only-config.xml");
	
		// Note: Files names log4j.properties and log4j.xml will be loaded
		// automatically, even without calling configure()
		
		
		// From here on, use the Logger objects to log messages:
		
		// These logging requests allow us to see the effect
		// of changing the severity level with which each logger
		// accepts messages. Try changing the severity level in 
		// the properties file to observe which logging requests 
		// are honored by the appenders they refer to.
		
		programmerLog.trace("programmer log: trace message");
		programmerLog.debug("programmer log: debug message");
		programmerLog.info("programmer log: info message");
		programmerLog.warn("programmer log: warn message");
		programmerLog.error("programmer log: error message");
		programmerLog.fatal("programmer log: fatal message");
		
		consoleLog.trace("console log: trace message");
		consoleLog.debug("console log: debug message");
		consoleLog.info("console log: info message");
		consoleLog.warn("console log: warn message");
		consoleLog.error("console log: error message");
		consoleLog.fatal("console log: fatal message");
		
		managerLog.trace("manager log: trace message");
		managerLog.debug("manager log: debug message");
		managerLog.info("manager log: info message");
		managerLog.warn("manager log: warn message");
		managerLog.error("manager log: error message");
		managerLog.fatal("manager log: fatal message");

	}

}
