package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p>等待多个并发事件完成</p>
 * CountDownLatch 机制不是用来保护共享资源或者临界区。
 * 它是用来同步一个或者多个执行多个任务的线程。它只能使用一次。
 * 像之前解说的，一旦CountDownLatch的计数器到达0，任何对它的方法的调用都是无效的。
 * 如果你想再次同步，你必须创建新的对象。
 * @author maosx
 *
 */
public class CountDownLatchTest {
	
	public static void main(String[] args) {
		Videoconference video = new Videoconference(10);
		Thread videoThread = new Thread(video,"videoThread");
		videoThread.start();
		
		
		for(int i = 0;i <10;i++){
			Thread thread = new Thread(new Participants(video, "thread-"+i));
			thread.start();
		}
		
	}
	
	public static class Videoconference implements Runnable{
		private final CountDownLatch controller;
		
		public Videoconference(int num) {
			controller = new CountDownLatch(num);
		}
		
		@Override
		public void run() {
			System.out.println("Video initialization: "+controller.getCount()+" .");
			try {
				controller.await();
				System.out.println("All participants have finish.");
				System.out.println("Video start......");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void arrive(String name){
			System.out.println(name+" has arrived .");
			controller.countDown();
			System.out.println(name+" count: "+controller.getCount());
		}
	}
	
	public static class Participants implements Runnable{
		
		private Videoconference video;
		private String name;
		
		public Participants(Videoconference video,String name){
			this.video = video;
			this.name = name;
		}
		
		
		@Override
		public void run() {
			long duration=(long)(Math.random()*10);
			try {
			    TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			//18. Ȼ��ʹ��Videoconference �����arrive() ���������������ߵĵ��
			video.arrive(name);
		}
		
	}
}
