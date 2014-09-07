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
	
	public static void main(String[] args) throws Exception {
		// remover
		args = new String[] {"/Users/joaogabriel/Pictures/teste-photorganizer"};
		
		Date takeDate = null;
		String sourceDirectory = args[0];
		File diretorioOrigemFile = new File(sourceDirectory);
		PhotoAnalyzer photoAnalyzer = new PhotoAnalyzer();
		DirectoryResolver directoryResolver = new DirectoryResolver();
		
		logger.info("Init execution with parameters = {} {}", args, "ovo");
		
//		for (File photo : diretorioOrigemFile.listFiles(new PhotoExtensionsFilter())) {
//			takeDate = photoAnalyzer.getTakeDate(photo);
//			
//			if (takeDate != null) {
//				directoryResolver.resolve(sourceDirectory, photo, takeDate);
//			}
//		}
		
		logger.info("Finishing execution");
	}

}
