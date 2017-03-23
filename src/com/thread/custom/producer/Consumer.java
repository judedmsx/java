package com.thread.custom.producer;

public class Consumer implements Runnable {
	private MyPriorityTransferQueue<Event> buffer;
	
	public Consumer(MyPriorityTransferQueue<Event> buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		try {
			for(int i=0;i<1002;i++){
				Event value = buffer.take();
				System.out.printf("Consumer: %s: %d\n",value.getThread(),value.getPriority());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
