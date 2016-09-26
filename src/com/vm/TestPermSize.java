package com.vm;

import java.util.ArrayList;
import java.util.List;

public class TestPermSize {
	public static void main(String[] args) {
		
	}
	
	public static void method1(){
		List<String> list = new ArrayList<String>();
		
		int i = 0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
	
	
}
