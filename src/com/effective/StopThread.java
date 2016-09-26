package com.effective;

import java.util.concurrent.TimeUnit;

public class StopThread {
	private static boolean stopRequested;
	
	private static synchronized void requestStop(){
		stopRequested = true;
	}
	
	private static synchronized boolean stopRequested(){
		return stopRequested;
	}
	
	public static void main(String[] args) throws Exception {
		Thread backgroundThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while(!stopRequested()){
					System.out.println(stopRequested);
					i++;
					System.out.println("======"+i);
				}
			}
		});
		
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}
