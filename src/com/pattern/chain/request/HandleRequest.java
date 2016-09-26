package com.pattern.chain.request;

public class HandleRequest {
	private Topic topic;

	public HandleRequest(Topic topic) {
		super();
		this.topic = topic;
	}
	
	public Topic getTopic(){
		return this.topic;
	}
}
