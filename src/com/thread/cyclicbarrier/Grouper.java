package com.thread.cyclicbarrier;

public class Grouper implements Runnable {
	private Results results;
	
	public Grouper(Results results){
		this.results = results;
	}
	
	@Override
	public void run() {
		int finalResult = 0;
		System.out.println("Grouper : Processing results ....");
		int data[] = results.getData();
		for(int i = 0;i < data.length;i++){
			finalResult += data[i];
		}
		
		System.out.println("Grouper : total result "+finalResult);
	}
}
