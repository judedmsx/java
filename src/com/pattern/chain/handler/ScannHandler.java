package com.pattern.chain.handler;

import com.pattern.chain.request.Topic;

public class ScannHandler extends Handler{

	@Override
	public void handle() {
		System.out.println("ÕıÔÚÉ¨Ãè--");
	}

	@Override
	public Topic getTopic() {
		// TODO Auto-generated method stub
		return Topic.SCANN;
	}
	
	
}
