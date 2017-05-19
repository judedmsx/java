package com.effective.singleton;

public class Singleton1 {
	
	private Singleton1(){}
	
	private static class Inner{
		public static Singleton1 instance = new Singleton1();
	}
	
	public static Singleton1 getInstance(){
		return Inner.instance;
	}
	
	public static void main(String[] args) {
		Singleton1 instance_1 = Singleton1.getInstance();
		Singleton1 instance_2 = Singleton1.getInstance();
		System.out.println(instance_1==instance_2);
	}
}
