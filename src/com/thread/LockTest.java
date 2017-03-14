package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	
	public static void main(String[] args) {
		final ReentrantLock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();
		
		Thread thread1 = new Thread((Runnable)()->{
			try{
				lock.lock();
				SleepUtils.second(5);
				System.out.println("thread-1 get lock.");
				System.out.println("thread-1 wait siganl");
				condition.await();
			}catch(Exception e){
			}finally{
				System.out.println("thread-1 get siganl");
				lock.unlock();
			}
		});
		
		Thread thread2 = new Thread((Runnable)()->{
			lock.lock();
			System.out.println("thread-2 get lock.");
			SleepUtils.second(10);
			condition.signalAll();
			System.out.println("thread-2 signal all...");
			
			lock.unlock();
		});
		
		Thread thread3 = new Thread((Runnable)()->{
			lock.lock();
			System.out.println("thread-3 get lock.");
			SleepUtils.second(6);
			lock.unlock();
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
