package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Class<?> clazz = Class.forName("com.reflection.Elvis");
		
		Class<?> clazz = ElvisEnum.class;
		for(Constructor<?> constructor : clazz.getDeclaredConstructors()){
			System.out.println(constructor.getName()+"--"+constructor.isAccessible());
			constructor.setAccessible(true);
			constructor.newInstance();
		}
	}
}
