package com.joaotech.photorganizer.photo;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import com.joaotech.photorganizer.util.PropertiesUtil;

public class PhotoExtensionsFilter implements FileFilter {

	private List<String> allowedFiles;
	
	public PhotoExtensionsFilter() {
		allowedFiles = new ArrayList<String>();
		
		for (String allowedFile : PropertiesUtil.getProperty("allowedFiles").split(";")) {
			allowedFiles.add(allowedFile.toLowerCase());
		}
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
