package com.pattern.chain.handler;

import com.pattern.chain.request.HandleRequest;
import com.pattern.chain.request.Topic;

public abstract class Handler {
	private Handler successor; //ºÃ≥–»À
	
	abstract public void handle();
	
	public void setSuccessor(Handler successor){
		this.successor = successor;
	}
	
	public void handleRequest(HandleRequest request){
		if(request.getTopic() == getTopic()){
			this.handle();
		}else{
			successor.handle();
		}
	}
	
	abstract public Topic getTopic();
}
