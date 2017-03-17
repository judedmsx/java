package com.thread.schedule;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		//demo1();
//		demo2();
		demo3();
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
	
	public static void demo3(){
		ExecutorService executor = Executors.newFixedThreadPool(1);
		System.out.printf("main thread Starting at : %s \n",new Date());
		Task task = new Task("task_"+1);
		
		Future result = executor.submit(task);
		
		result.cancel(true);
		
		System.out.println(result.isDone());
		System.out.println(result.isCancelled());
		
		executor.shutdown();
	}
}
