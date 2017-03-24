package com.thread.test;

import java.util.concurrent.Phaser;

import com.thread.SleepUtils;

public class Task implements Runnable {
	private int time;
	private Phaser phaser;
	
	public Task(int time, Phaser phaser) {
		super();
		this.time = time;
		this.phaser = phaser;
	}

	@Override
	public void run() {
		phaser.arrive();
		System.out.printf("%s: Entering phase 1.\n",Thread. currentThread().getName());
		SleepUtils.second(time);
		System.out.printf("%s: Finishing phase 1.\n",Thread. currentThread().getName());
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("%s: Entering phase 2.\n",Thread. currentThread().getName());
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("%s: Entering phase 3.\n",Thread. currentThread().getName());
		phaser.arriveAndAwaitAdvance();
		SleepUtils.second(time);
		System.out.printf("%s: Finishing phase 3.\n",Thread. currentThread().getName());
		
		phaser.arriveAndDeregister();
	}

}
