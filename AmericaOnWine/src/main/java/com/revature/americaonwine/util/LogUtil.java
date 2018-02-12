package com.revature.americaonwine.util;

import org.apache.log4j.Logger;

public class LogUtil {

	private static Logger log = Logger.getLogger(LogUtil.class);
	
	public static void logException(Exception e) {
		log.error(e.getClass() + ": " + e.getMessage());
		for (StackTraceElement s : e.getStackTrace()) {
			log.warn(s.getLineNumber() + ": " + s.getClassName());
		}
	}
}
