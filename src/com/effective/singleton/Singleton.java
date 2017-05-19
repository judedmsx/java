package com.effective.singleton;

public class Singleton {
	private static volatile Singleton instance;
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(instance==null){
			synchronized (Singleton.class) {
				if(instance==null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	
	
	public static void main(String[] args) {
		Singleton instance_1 = Singleton.getInstance();
		Singleton instance_2 = Singleton.getInstance();
		System.out.println(instance_1==instance_2);
	}
}
