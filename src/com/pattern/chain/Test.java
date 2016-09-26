package com.pattern.chain;

import com.pattern.chain.handler.PrintHandler;
import com.pattern.chain.handler.ScannHandler;
import com.pattern.chain.request.HandleRequest;
import com.pattern.chain.request.Topic;

public class Test {
	public static void main(String[] args) {
		HandleRequest request = new HandleRequest(Topic.SCANN);
		
		PrintHandler printHandler = new PrintHandler();
		ScannHandler scannHandler = new ScannHandler();
		
		printHandler.setSuccessor(scannHandler);
		printHandler.handleRequest(request);
	}
}
