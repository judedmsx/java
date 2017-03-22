package com.thread.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>>{


	private static final long serialVersionUID = 766149680421427331L;
	private String path;
	private String extension;
	
	@Override
	protected List<String> compute() {
		List<String> list=new ArrayList<>();
		List<FolderProcessor> tasks=new ArrayList<>();
		File file=new File(path);
		File content[] = file.listFiles();
		
		return null;
	}

}
