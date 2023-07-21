package com.cucumberFramework.helper;

import org.slf4j.LoggerFactory;

public class LoggerHelper {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerHelper.class);

	public void debugLog(String message) {
		logger.debug(message);
	}

	public void infoLog(String message) {
		logger.info(message);
	}

	public void errorLog(String message) {
		logger.error(message);
	}
}