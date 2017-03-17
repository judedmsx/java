package com.thread.completion;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 * 执行者分离任务的启动和结果的处理
 * @author maosx
 *
 */
public class ReportProcessor implements Runnable{
	private CompletionService<String> service;
	private boolean end;
	
	public ReportProcessor(CompletionService<String> service) {
		super();
		this.service = service;
		this.end = false;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	@Override
	public void run() {
		while(!end){
			try {
				Future<String> result = service.poll(20,TimeUnit.SECONDS);
				if(result!=null){
					String report = result.get();
					System.out.printf("ReportReceiver: Report Received:%s\n",report);
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("ReportSender: End\n");
	}

}
