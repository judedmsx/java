package com.thread.phaser;

import java.util.concurrent.Phaser;

import com.thread.SleepUtils;
/**
 * countdownlatch
 * @author maosx
 *
 */
public class PhaserTest2 {
	
	public static void main(String[] args) {
		Phaser phaser = new Phaser(5);
		
		Traveler traveler = new Traveler(phaser);
		Thread thread = new Thread(traveler,"tread-traveler");
		thread.start();
		
		for(int i = 0;i < 5;i++){
			Thread taskTread = new Thread(new Task(traveler),"thread-"+i);
			taskTread.start();
		}
	}
	
	
	public static class Traveler implements Runnable{
		private Phaser phaser;
		public Traveler(Phaser phaser){
			this.phaser = phaser;
		}
		
		public void Climbing(){
			long sleep = (long)(Math.random()*10);
			System.out.println(Thread.currentThread().getName()+" Climbing ... and waiting others. and sleep "+sleep);
			SleepUtils.second(sleep);
			int number = phaser.arrive();
			System.out.println(Thread.currentThread().getName()+" Climbing ... phaser number . "+phaser.getPhase());
		}
		
		@Override
		public void run() {
			System.out.println("begin rest....."+phaser.getPhase());
			phaser.awaitAdvance(phaser.getPhase());
			System.out.println("end rest....."+phaser.getPhase());
		}
	}
	
	public static class Task implements Runnable{
		private Traveler traveler;
		public Task(Traveler traveler){
			this.traveler = traveler;
		}
		
		@Override
		public void run() {
			this.traveler.Climbing();
		}
	}
	
}
