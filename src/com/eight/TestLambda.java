package com.eight;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLambda {
	public static void demo1(){
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"}; 
//		List<String> players = Arrays.asList(atp);
//		players.forEach((player)->System.out.println(player+";"));
	}
	
	public void demo2(){
		List<String> names = Arrays.asList("apple","orange","banana");
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		Collections.sort(names, 
				(String a,String b)->{ return b.compareTo(a);});
		
	}
	/**
	 * 函数式接口
	 */
	public void demo3(){
		Converter<String, Integer> convert = (from)->Integer.valueOf(from);
		Integer converted = convert.convert("1");
	}
	
	/**
	 * 方法与构造函数引用
	 */
	public static void demo4(){
		Converter<String,Integer> convert = Integer::valueOf;
		System.out.println(convert.convert("123"));
		
		PersonFactory<Person> factory = Person::new;
		Person p = factory.create("mr", " lucy");
		System.out.println(p.getFirstName());
	}
	
	/**
	 * 访问局部变量
	 */
	public static void demo5(){
		final int num =1;
		Converter<Integer,String> conveter = (from)->String.valueOf(from+num);
		System.out.println(conveter.convert(2));
		
	}
	
	
	
	public static void main(String[] args) {
		demo5();
	}
}
