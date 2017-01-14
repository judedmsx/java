package com.vm;

public class SuperClass {
	static{
		System.out.println("SuperClass init!");
	}
	public static int value=123;
	
	public static class SubClass extends SuperClass{
		static{
			System.out.println("SubClass init!");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(SubClass.value);
	}
}
