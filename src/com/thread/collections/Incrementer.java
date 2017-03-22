package com.thread.collections;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Incrementer implements Runnable {
	
	private AtomicIntegerArray vector;

	public Incrementer(AtomicIntegerArray vector) {
		super();
		this.vector = vector;
	}



	@Override
	public void run() {
		for(int i=0;i<vector.length();i++){
			vector.getAndIncrement(i);
		}
	}

}
