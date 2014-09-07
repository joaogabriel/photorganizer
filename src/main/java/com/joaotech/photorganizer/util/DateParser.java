package com.joaotech.photorganizer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(PropertiesUtil.getProperty("dateFormat")); 
	
	public static String getFormattedDate(Date date) {
		return dateFormat.format(date);
	}
	
}
