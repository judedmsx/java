package com.thread.schedule;

import java.util.Date;
import java.util.concurrent.Callable;

import com.thread.SleepUtils;

public class Task implements /*Callable<String>*/ Runnable{
	
	private String name;
	
	public Task(String name){
		this.name = name;
	}

	@Override
	public void run() {
		
		System.out.printf("%s Starting at : %s \n",name,new Date());
		
		SleepUtils.second(100);
		
		System.out.printf("%s Ending at : %s \n",name,new Date());
	}

/*	@Override
	public String call() throws Exception {
		System.out.printf("%s Starting at : %s \n",name,new Date());
		return "hello,world! "+name;
	}*/
	
	

}
