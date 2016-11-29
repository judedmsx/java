package com.introspector;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestIntrospector {
	public static void main(String[] args) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		User user = new User();
		
		PropertyDescriptor des = new PropertyDescriptor("age", user.getClass());
		Method write = des.getWriteMethod();
		
		write.invoke(user, 10);
		System.out.println(user.getAge());
		
		user.setName("john");
		des = new PropertyDescriptor("name", user.getClass());
		Method read = des.getReadMethod();
		System.out.println(read.invoke(user));
	}
}
