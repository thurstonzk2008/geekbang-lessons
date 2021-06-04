package org.geektimes.projects.spring.cloud.config.filebasedconfig.resource;

import java.io.File;

import org.springframework.core.io.ContextResource;
import org.springframework.core.io.FileSystemResource;


public class FileSystemContextResource extends FileSystemResource implements ContextResource {


	public FileSystemContextResource(File file) {
		super(file);
	}

	@Override
	public String getPathWithinContext() {
		return getPath();
	}

}