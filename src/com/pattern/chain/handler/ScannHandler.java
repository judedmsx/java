package com.pattern.chain.handler;

import com.pattern.chain.request.Topic;

public class ScannHandler extends Handler{

	@Override
	public void handle() {
		System.out.println("����ɨ��--");
	}

	@Override
	public Topic getTopic() {
		// TODO Auto-generated method stub
		return Topic.SCANN;
	}
	
	
}
