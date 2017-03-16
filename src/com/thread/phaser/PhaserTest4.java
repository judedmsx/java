package com.thread.phaser;

import java.util.concurrent.Phaser;

import com.thread.SleepUtils;
import com.thread.phaser.PhaserTest3.Task;

/**
 * CyclicBarrier支持barrier action, Phaser同样也支持。
 * 不同之处是Phaser的barrier action需要改写onAdvance方法来进行定制。
 * @author maosx
 *
 */
public class PhaserTest4 {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(5){
			@Override
			protected boolean onAdvance(int phase, int registeredParties) {
				System.out.println("========"+phase+"======"+registeredParties+"=======");
				return phase>=3;
			}
		};
		
		for(int i=0;i<5;i++){
			System.out.println("starting tread,id : "+i);
			Thread thread = new Thread(new Task(i,phaser),"thread-"+i);
			thread.start();
		}
	}
	
	public static class Task implements Runnable{
		private int id;
		private Phaser phaser;
		public Task(int id,Phaser phaser){
			this.id = id;
			this.phaser = phaser;
		}
		@Override
		public void run() {
			do{
				long sleep = (long)(Math.random()*10);
				SleepUtils.second(sleep);
				phaser.arriveAndAwaitAdvance();
				System.out.println("int task.run() phase: "+phaser.getPhase()+" ,id: "+id);
			}while(!phaser.isTerminated());
		}
	}
}
