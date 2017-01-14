package com.vm;

import java.util.ArrayList;
import java.util.List;

public class TestPermSize {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl = new MyClassLoader("/Users/maosx/Documents/workspace/java/bin");
		Class c = cl.loadClass("com.vm.TestPermSize");
		Object obj = c.newInstance();
		System.out.println(obj instanceof com.vm.TestPermSize);
	}
	
	public static void method1(){
		List<String> list = new ArrayList<String>();
		
		int i = 0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
	
	
}
