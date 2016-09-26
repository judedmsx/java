package com.effective;

public class TestClone implements Cloneable{
	private String name;
	public TestClone(String name){
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static void main(String[] args) throws Exception {
		TestClone test1 = new TestClone("aaa");
		TestClone test2 = (TestClone) test1.clone();
		TestClone test3 = (TestClone) test1.clone();
		System.out.println(test2.getName());
		System.out.println(test1 != test2);
		System.out.println(test1.getClass() == test2.getClass());
		System.out.println(test1.equals(test2));
	}
}
