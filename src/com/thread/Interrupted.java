package com.thread;

public class Interrupted {
	public static void main(String[] args) {
		Thread sleepThread = new Thread(new SleepRunner(), "sleepthread");
		sleepThread.setDaemon(true);
		
		Thread busyThread = new Thread(new BusyRunner(), "busythread");
		busyThread.setDaemon(true);
		
		sleepThread.start();
		busyThread.start();
		
		SleepUtils.second(5);
		
		sleepThread.interrupt();
		busyThread.interrupt();
		
		System.out.println("sleepThread interrupted is "+sleepThread.isInterrupted());
		System.out.println("busyThread interrupted is "+busyThread.isInterrupted());
		
		SleepUtils.second(60);
	}
	static class SleepRunner implements Runnable{
		@Override
		public void run() {
			while(true){
				SleepUtils.second(10);
			}
		}
	}
	
	static class BusyRunner implements Runnable{
		@Override
		public void run() {
			while(true){
				
			}
		}
	}
}
