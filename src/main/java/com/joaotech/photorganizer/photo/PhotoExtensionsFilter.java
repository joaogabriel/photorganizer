package com.joaotech.photorganizer.photo;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joaotech.photorganizer.util.PropertiesUtil;

public class PhotoExtensionsFilter implements FileFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoExtensionsFilter.class);

	private List<String> allowedFiles;
	
	public PhotoExtensionsFilter() {
		allowedFiles = new ArrayList<String>();
		
		for (String allowedFile : PropertiesUtil.getProperty("allowedFiles").split(";")) {
			allowedFiles.add(allowedFile.toLowerCase());
		}
		
		logger.debug("Allowed files: {}", allowedFiles);
	}
	
	public boolean accept(File pathName) {
		boolean accept = false;
		String extension = null;
		
		if (pathName.isFile()) {
			extension = getExtension(pathName.getName());
			
			accept = allowedFiles.contains(extension.toLowerCase());
		}
		
		return accept;
	}
	
	private String getExtension(String name) {
		return name.split("\\.")[1];
	}

}
