package com.joaotech.photorganizer.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil {

	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	
	private static final String PROPERTIES_NAME_FILE = "config.properties";
	
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_NAME_FILE));
		} catch (IOException e) {
			logger.error("Error while init config properties", e);
		}
	}
	
	public static Properties getProperties() {
		return properties;
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
