package com.thread.collections.blocklist;

import java.util.concurrent.LinkedBlockingDeque;

import com.thread.SleepUtils;

public class Client implements Runnable {
	private LinkedBlockingDeque<String> requestList;
	
	public Client(LinkedBlockingDeque<String> requestList) {
		super();
		this.requestList = requestList;
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<3;i++){
				for(int j=0;j<5;j++){
					StringBuilder request = new StringBuilder();
					request.append(i).append(":").append(j);
					requestList.put(request.toString());
					SleepUtils.second(4);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SleepUtils.second(2);
		System.out.println("Clinet end.");
	}

}
