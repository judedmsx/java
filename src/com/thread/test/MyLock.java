package com.thread.test;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 监控Lock接口
 * @author maosx
 *
 */
public class MyLock extends ReentrantLock {

	public String getOwnerName(){
		if(this.getOwner()==null)
			return "none";
		return this.getOwner().getName();
	}
	
	public Collection<Thread> getThreads(){
		return this.getQueuedThreads();
	}
	
	public class Task implements Runnable{
		private Lock lock;
		
		public Task(Lock lock){
			this.lock = lock;
		}

		@Override
		public void run() {
			for(int i=0;i<5;i++){
				lock.lock();
				System.out.printf("%s: Get the Lock.\n", Thread.currentThread().getName());
				try {
					TimeUnit.MILLISECONDS.sleep(500);
					System.out.printf("%s: Free the Lock.\n", Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyLock lock = new MyLock();
		Thread threads[] = new Thread[5];
		for(int i=0;i<5;i++){
			Task task = lock.new Task(lock);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		
		// 14. 创建迭代15次的for循环。
		for (int i = 0; i < 15; i++) {

			// 15. 把锁的拥有者的名字写入操控台。
			System.out.printf("Main: Logging the Lock\n");
			System.out.printf("************************\n");
			System.out.printf("Lock: Owner : %s\n", lock.getOwnerName());

			// 16. 显示锁queued的线程的号码和名字。
			System.out.printf("Lock: Queued Threads: %s\n",
					lock.hasQueuedThreads()); // 译者注：加上 System
			if (lock.hasQueuedThreads()) {
				System.out.printf("Lock: Queue Length: %d\n",
						lock.getQueueLength());
				System.out.printf("Lock: Queued Threads: ");
				Collection<Thread> lockedThreads = lock.getThreads();
				for (Thread lockedThread : lockedThreads) {
					System.out.printf("%s ", lockedThread.getName());
				}
				System.out.printf("\n");
			}

			// 17. 显示关于Lock对象的公平性和状态的信息。
			System.out.printf("Lock: Fairness: %s\n", lock.isFair());
			System.out.printf("Lock: Locked: %s\n", lock.isLocked());
			System.out.printf("************************\n");

			// 18. 让线程休眠1秒，并合上类的循环。
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
