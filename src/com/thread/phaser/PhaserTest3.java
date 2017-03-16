package com.thread.phaser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Phaser;
/**
 * 有些时候我们希望只有在某些外部条件满足时，才真正开始任务的执行
 * @author maosx
 *
 */
public class PhaserTest3 {
	public static void main(String[] args) throws IOException {
		Phaser phaser = new Phaser(1);
		for(int i=0;i<5;i++){
			phaser.register();
			System.out.println("starting tread,id : "+i);
			Thread thread = new Thread(new Task(i,phaser),"thread-"+i);
			thread.start();
		}
		
		System.out.println("Press ENTER to continue"); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
		phaser.arriveAndDeregister();
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
			phaser.arriveAndAwaitAdvance();
			System.out.println("int task.run() phase: "+phaser.getPhase()+" ,id: "+id);
		}
	}
}
