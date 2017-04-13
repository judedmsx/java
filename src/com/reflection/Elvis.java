package com.reflection;

public class Elvis {
	private static final Elvis INSTANCE = new Elvis();
	private Elvis(){
		System.out.println("Elvis is constructed");
	}
	
	public static Elvis getInstance(){
		return INSTANCE;
	}
}
