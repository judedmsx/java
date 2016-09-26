package com.pattern.chain.handler;

import com.pattern.chain.request.Topic;

public class PrintHandler extends Handler{

	@Override
	public void handle() {
		System.out.println("���ڴ�ӡ----");
	}

	@Override
	public Topic getTopic() {
		// TODO Auto-generated method stub
		return Topic.PRINT;
	}
	
	
}
