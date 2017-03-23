package com.thread.custom.producer;

import com.thread.SleepUtils;
/**
 * 实现一个基于优先级的传输队列</p>
 * LinkedTransferQueue：这个数据类型支持那些有生产者和消费者结构的程序。 在那些应用，你有一个或者多个数据生产者，一个或多个数据消费者和一个被生产者和消费者共享的数据类型。生产者把数据放入数据结构内，然后消费者从数据结构内提取数据。如果数据结构为空，消费者会被阻塞直到有数据可以消费。如果数据结构满了，生产者就会被阻塞直到有空位来放数据。</p>
 * PriorityBlockingQueue：在这个数据结构，元素是按照顺序储存的。元素们必须实现 带有 compareTo() 方法的 Comparable 接口。当你在结构中插入数据时，它会与数据元素对比直到找到它的位置。</p>
 * @author maosx
 *
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		MyPriorityTransferQueue<Event> buffer = new MyPriorityTransferQueue<>();
		
	/*	Producer producer = new Producer(buffer);
		Thread producerThreads[] = new Thread[10];
		
		for(int i=0;i<producerThreads.length;i++){
			producerThreads[i] = new Thread(producer);
			producerThreads[i].start();
		}
		
		
		
		System.out.printf("Main: Buffer: Consumer count: %d\n",buffer. getWaitingConsumerCount());
		*/
		
		Producer producer = new Producer(buffer);
		Thread producerThread = new Thread(producer);
		producerThread.start();
		
		SleepUtils.second(30);
		
		Consumer consumer=new Consumer(buffer);
		Thread consumerThread=new Thread(consumer);
		consumerThread.start();
		
		
		// 使用 transfer() 方法传输一个事件给消费者。
	/*	Event myEvent=new Event("Core Event",0);
		buffer.transfer(myEvent);
		System.out.printf("Main: My Event has ben transfered.\n");*/
		
	
	}
}
