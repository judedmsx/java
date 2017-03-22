package com.thread.collections;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Decrementer implements Runnable {
	private AtomicIntegerArray vector;
	
	public Decrementer(AtomicIntegerArray vector) {
		super();
		this.vector = vector;
	}
	
	@Override
	public void run() {
		for(int i=0;i<vector.length();i++){
			vector.getAndDecrement(i);
		}
	}

}
