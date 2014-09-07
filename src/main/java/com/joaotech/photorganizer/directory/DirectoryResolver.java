package com.joaotech.photorganizer.directory;

import java.io.File;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joaotech.photorganizer.util.DateParser;

public class DirectoryResolver {

	private static final Logger logger = LoggerFactory.getLogger(DirectoryResolver.class);
	
	public void resolve(String sourceDirectory, File photo, Date takeDate) throws Exception {
		String folderName = DateParser.getFormattedDate(takeDate);
		File destinationDirectory = new File(makePath(sourceDirectory, folderName));
		File originalPhoto = new File(makePath(sourceDirectory, photo.getName()));
		File organizedPhoto = new File(makePath(destinationDirectory.getAbsolutePath(), photo.getName()));
		
		if (!destinationDirectory.exists()) {
			logger.info("Success to create dir {}", destinationDirectory.mkdir());
		}
		
		originalPhoto.renameTo(organizedPhoto);
	}

	private String makePath(String... paths) {
		StringBuilder path = new StringBuilder();
		
		for (String onePath : paths) {
			path.append(onePath).append(File.separator);
		}
		
		return path.toString();
	}
	
}
