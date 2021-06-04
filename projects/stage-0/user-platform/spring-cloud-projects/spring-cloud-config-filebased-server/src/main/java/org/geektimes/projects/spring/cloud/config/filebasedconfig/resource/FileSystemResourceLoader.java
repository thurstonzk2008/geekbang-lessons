package org.geektimes.projects.spring.cloud.config.filebasedconfig.resource;

import java.io.File;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;


public class FileSystemResourceLoader extends DefaultResourceLoader {

	@Override
	protected Resource getResourceByPath(String path) {
		File file = new File(path);
		return new FileSystemContextResource(file);
	}

}