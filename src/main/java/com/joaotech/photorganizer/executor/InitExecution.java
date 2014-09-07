package com.joaotech.photorganizer.executor;

import java.io.File;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joaotech.photorganizer.directory.DirectoryResolver;
import com.joaotech.photorganizer.photo.PhotoAnalyzer;
import com.joaotech.photorganizer.photo.PhotoExtensionsFilter;

public class InitExecution {

	private static final Logger logger = LoggerFactory.getLogger(InitExecution.class);
	
	public static void main(String[] args) {
		Date takeDate = null;
		String sourceDirectory = null;
		File diretorioOrigemFile = null;
		PhotoAnalyzer photoAnalyzer = null;
		DirectoryResolver directoryResolver = null;
		
		logger.info("Init execution with parameters = {} {}", args, "");
		
		try {
			if (args.length == 0) {
				throw new Exception("No parameters set to program arguments");
			}
			
			sourceDirectory = args[0];
			diretorioOrigemFile = new File(sourceDirectory);
			photoAnalyzer = new PhotoAnalyzer();
			directoryResolver = new DirectoryResolver();
			
			for (File photo : diretorioOrigemFile.listFiles(new PhotoExtensionsFilter())) {
				takeDate = photoAnalyzer.getTakeDate(photo);
				
				if (takeDate != null) {
					directoryResolver.resolve(sourceDirectory, photo, takeDate);
				}
			}
			
			logger.info("Finishing execution");
		} catch (Throwable t) {
			logger.error("Error during execution", t);
		}
	}

}
