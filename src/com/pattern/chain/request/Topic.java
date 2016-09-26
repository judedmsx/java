package com.pattern.chain.request;

public enum Topic {
	PRINT("PRINT"),SCANN("SCANN");
	
	private String topic;
	
	private Topic(String topic){
		this.topic = topic;
	}
}
