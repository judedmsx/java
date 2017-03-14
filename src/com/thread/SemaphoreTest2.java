package com.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 信号量：控制并发访问多个资源
 * @author maosx
 *
 */
public class SemaphoreTest2 {
	
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		for(int i = 0;i < 10;i++){
			Thread thread = new Thread(new Job(printQueue), "thread-"+i);
			thread.start();
		}
	}
	
	public static class PrintQueue{
		private Semaphore semaphore;
		private Lock lock;
		private boolean []freePrinters = new boolean[3];
		public PrintQueue(){
			this.semaphore = new Semaphore(3);
			lock = new ReentrantLock();
			for(int i = 0;i < freePrinters.length;i++){
				freePrinters[i] = true;
			}
		}
		
		public void printJob(){
			try {
				semaphore.acquire();
				long duration=(long)(Math.random()*10);
				
				int i = getPrinter();
				
				System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",
						Thread.currentThread().getName(),i,duration);
				
				SleepUtils.second(duration);
				
				freePrinters[i] = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaphore.release();
			}
		}
		
		public int getPrinter(){
			int ret = -1;
			try {
				lock.lock();
				for(int i = 0;i < freePrinters.length;i++){
					if(freePrinters[i]){
						freePrinters[i] = false;
						ret = i;
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
			return ret;
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
