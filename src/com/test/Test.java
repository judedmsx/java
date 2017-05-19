package com.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Test {
	String str = new String("good");
	char []ch = {'a','b','c'};
	public static void main(String[] args) {
		/*int x = test();
		System.out.println("main === "+x);*/
		/*testRenMinBi(12345);
		Object []array = new Long[1];
		array[0]="i am maosx.";
		
		Set<Integer> integers = new HashSet<>();
		Set<Double> doubles = new HashSet<>();
		Test.<Number>union(integers, doubles);*/
		String s1 = "hello";
		String s2 = "he"+new String("llo");
		System.out.println(s1==s2);
		
		
		
		
		Test test = new Test();
		test.change(test.str, test.ch);
		System.out.println(test.str+" and ");
		System.out.println(test.ch);
	}
	
	public void change(String str,char ch[]){
		str = "test ok";
		ch[0] = 'g';
	}
	
	
	public static <E> Set<E> union(Set<? extends E> src,Set<? extends E> dest){
		return null;
	} 
	
	public static int test(){
		int x=1;
		try{
			return x;
		}finally{
			++x;
			System.out.println("==== " + x);
		}
	}
	
	public static void testRenMinBi(int money){
		char[] data = new char[]{
				'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'
			}; 
		
		char[] units = new char[]{
				'元','拾','佰','仟','万','拾','佰','仟','亿'
			};

		StringBuffer sbf = new StringBuffer();
		int unit = 0;
		while(money!=0){
			sbf.insert(0,units[unit++]);
			int number = money%10;
			sbf.insert(0, data[number]);
			money /= 10;
		}
		
		System.out.println(sbf.toString());
	}
}
