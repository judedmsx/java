package com.thread.custom.producer;

public class Producer implements Runnable {
	//声明一个私有 MyPriorityTransferQueue 属性，接收参数化的 Event  类属性，名为 buffer，用来储存这个生产者生成的事件。
	private MyPriorityTransferQueue<Event> buffer;
	
	public Producer(MyPriorityTransferQueue<Event> buffer) {
		super();
		this.buffer = buffer;
	}



	@Override
	public void run() {
		/*for(int i=0;i<100;i++){
			Event event = new Event(Thread.currentThread().getName(), i);
			this.buffer.put(event);
		}*/
		try {
			Event myEvent=new Event("Core Event",0);
			buffer.transfer(myEvent);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
