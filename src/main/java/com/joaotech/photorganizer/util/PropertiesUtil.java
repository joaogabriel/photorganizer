package com.joaotech.photorganizer.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	private static final String PROPERTIES_NAME_FILE = "config.properties";
	
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_NAME_FILE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Properties getProperties() {
		return properties;
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
