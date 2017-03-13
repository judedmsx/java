package com.thread;

public class Yield {
	public static Object lock = new Object();
	
	public static void main(String[] args) {
		for(int i = 0;i < 10;i++){
			Thread thread = new Thread(new Runner(i), "thread-"+i);
			thread.start();
		}
	}
	
	static class Runner implements Runnable{
		private int i ;
		public Runner(int i){
			this.i = i;
		}

		@Override
		public void run() {
			synchronized (lock) {
				System.out.println("start ======"+i);
				Thread.yield();
				System.out.println("end ========"+i);
			}
		}
	}
}
