package com.thread;

import java.util.concurrent.Semaphore;
/**
 * 信号量：控制并发访问一个资源
 * @author maosx
 *
 */
public class SemaphoreTest {
	
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		for(int i = 0;i < 10;i++){
			Thread thread = new Thread(new Job(printQueue), "thread-"+i);
			thread.start();
		}
	}
	
	public static class PrintQueue{
		private Semaphore semaphore;
		public PrintQueue(){
			this.semaphore = new Semaphore(1);
		}
		
		public void printJob(){
			try {
				semaphore.acquire();
				long duration=(long)(Math.random()*10);
				System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",
						Thread.currentThread().getName(),duration);
				SleepUtils.second(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaphore.release();
			}
		}
	}
	
	public static class Job implements Runnable{
		private PrintQueue printQueue;
		
		public Job(PrintQueue printQueue){
			this.printQueue = printQueue;
		}
		
		@Override
		public void run() {
			System.out.printf("%s: Going to print a job\n",Thread.currentThread().getName());
			
			printQueue.printJob();
			
			System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());
		}
	}
}
