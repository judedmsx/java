package com.thread.schedule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		//demo1();
		
		demo2();
	}
	
	public static void demo1(){
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
		System.out.printf("main thread Starting at : %s \n",new Date());
		for(int i = 0;i < 5;i++){
			Task task = new Task("task_"+i);
			executor.schedule(task, i+2, TimeUnit.SECONDS);
		}
		
		executor.shutdown();
	}
	
	public static void demo2(){
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
		System.out.printf("main thread Starting at : %s \n",new Date());
		Task task = new Task("task_"+1);
		executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);		
//		executor.shutdown();
	}
}
