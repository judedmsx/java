package com.test;

public class TestInnerClass {
	private int a;
	private String b;
	
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}


	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Inner inner = new TestInnerClass.Inner();
	}


	public static class Inner{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
}
