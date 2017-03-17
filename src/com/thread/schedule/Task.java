package com.thread.schedule;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements /*Callable<String>*/ Runnable{
	
	private String name;
	
	public Task(String name){
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s Starting at : %s \n",name,new Date());
	}

/*	@Override
	public String call() throws Exception {
		System.out.printf("%s Starting at : %s \n",name,new Date());
		return "hello,world! "+name;
	}*/
	
	

}
