package com.thread.phaser;

import java.util.concurrent.Phaser;

import com.thread.SleepUtils;
/**
 * CyclicBarrier，允许一组线程互相等待，直到到达某个公共屏障点。它提供的await()可以实现让所有参与者在临界点到来之前一直处于等待状态。</p>
 * CountDownLatch，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。它提供了await()、countDown()两个方法来进行操作。</p>
 * 在Phaser中，它把多个线程协作执行的任务划分为多个阶段，编程时需要明确各个阶段的任务，每个阶段都可以有任意个参与者，线程都可以随时注册并参与到某个阶段。
 * </p>
 * 同cyclicbarrier，最后一个线程调用arriveAndAwaitAdvance()唤醒所有等待的线程并继续执行任务。
 * @author maosx
 *
 */
public class PhaserTest {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(5);
		for(int i=0;i<5;i++){
			Thread thread = new Thread(new Task(phaser),"thread-"+i);
			thread.start();
		}
	}
	
	public static class Task implements Runnable{
		private Phaser phaser;
		public Task(Phaser phaser){
			this.phaser = phaser;
		}
		@Override
		public void run() {
			long sleep = (long)(Math.random()*10);
			System.out.println(Thread.currentThread().getName()+" sleep ...."+sleep+" -"+phaser.getPhase()+" | "+phaser.getArrivedParties());
			SleepUtils.second(sleep);
			phaser.arriveAndAwaitAdvance();//cyclicbarrier await()
			System.out.println(Thread.currentThread().getName()+" end ...."+" -"+phaser.getPhase()+" | "+phaser.getArrivedParties());
		}
	}
}
