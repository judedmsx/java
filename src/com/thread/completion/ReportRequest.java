package com.thread.completion;

import java.util.concurrent.CompletionService;

public class ReportRequest implements Runnable{
	
	private String name;
	private CompletionService<String> service;
	
	public ReportRequest(String name, CompletionService<String> service) {
		super();
		this.name = name;
		this.service = service;
	}



	@Override
	public void run() {
		ReportGenerator generator = new ReportGenerator(name, "report");
		service.submit(generator);
	}
}
