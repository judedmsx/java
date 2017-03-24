package com.thread.test;

import java.util.concurrent.Phaser;

import com.thread.SleepUtils;
/**
 * 监控Phaser类
 * @author maosx
 *
 */
public class Main {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		
		for(int i=0;i<3;i++){
			Thread thread = new Thread(new Task((i+1)*5, phaser), "phaser-thread-"+i);
			thread.start();
		}
		
		for(int i=0;i<10;i++){
			System.out.printf("********************\n");
			System.out.printf("Main: Phaser Log\n");
			System.out.printf("Main: Phaser: Phase: %d\n",phaser.getPhase());
			System.out.printf("Main: Phaser: Registered Parties:%d\n",phaser.getRegisteredParties());
			System.out.printf("Main: Phaser: Arrived Parties:%d\n",phaser.getArrivedParties());
			System.out.printf("Main: Phaser: Unarrived Parties:%d\n",phaser.getUnarrivedParties());
			System.out.printf("********************\n");

			SleepUtils.second(2);
		}
	}
}
