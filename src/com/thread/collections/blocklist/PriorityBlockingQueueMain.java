package com.thread.collections.blocklist;

import java.util.concurrent.PriorityBlockingQueue;
/**
 * 优先级对使用阻塞线程安全的列表排序
 * @author maosx
 *
 */
public class PriorityBlockingQueueMain {
	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
		Thread taskThreads[] = new Thread[5];
		
		for(int i=0;i<taskThreads.length;i++){
			taskThreads[i] = new Thread(new Task(i, queue));
		}
		
		for(int i=0;i<taskThreads.length;i++){
			taskThreads[i].start();
		}
		
		for(int i=0;i<taskThreads.length;i++){
			taskThreads[i].join();
		}
		
		System.out.println("Main : queue size +" + queue.size());
		
		for(int i=0;i<taskThreads.length*100;i++){
			Event event = queue.poll();
			System.out.println("event thread: "+event.getThread()+" priority: "+event.getPriority());
		}
		
		System.out.println("Main : queue size +" + queue.size());
	}
}
