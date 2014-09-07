package com.joaotech.photorganizer.photo;

import java.io.File;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

public class PhotoAnalyzer {

	private static final Logger logger = LoggerFactory.getLogger(PhotoAnalyzer.class);
	
	public Date getTakeDate(File photo) throws Exception {
		Date takeDate = null;
		
		// obtain the metadata
		Metadata metadata = ImageMetadataReader.readMetadata(photo);
		
		// obtain the Exif directory
		ExifSubIFDDirectory directory = metadata.getDirectory(ExifSubIFDDirectory.class);
		
		if (directory == null) {
			logger.info("no exif for file {}", photo);
		} else {
			// query the tag's value
			takeDate = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
		}
		
		return takeDate;
	}
	
}
