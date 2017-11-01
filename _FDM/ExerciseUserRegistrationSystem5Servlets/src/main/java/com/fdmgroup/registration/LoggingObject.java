package com.fdmgroup.registration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public final class LoggingObject 
{
	static Logger programmerLog = Logger.getLogger("programmerLog");
	
	public static void log(String someInput, int severity)
	{
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		
		if(severity == 0)
		{
			programmerLog.trace(someInput); //"programmer log: trace message");
		}
		else if(severity == 1)
		{
			programmerLog.debug(someInput); //"programmer log: debug message");
		}
		else if(severity == 2)
		{
			programmerLog.info(someInput); //"programmer log: info message");
		}
		else if(severity == 3)
		{
			programmerLog.warn(someInput); //"programmer log: warn message");
		}
		else if(severity == 4)
		{
			programmerLog.error(someInput); //"programmer log: error message");
		}
		else if(severity == 5)
		{
			programmerLog.fatal(someInput); //"programmer log: fatal message");
		}
	}
}
