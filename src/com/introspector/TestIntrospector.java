package com.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;

public class TestIntrospector {
	public static void main(String[] args) throws Exception {
//		test2();
		URI uri = new URI("http://www.wanjiadr.com");
		System.out.println(uri.getHost());
		System.out.println(uri.getPort());
	}
	
	public static void test1() throws Exception{
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
	
	public static void test2() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		User user = new User();
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
		PropertyDescriptor pds [] = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
			if("age".equals(pd.getName())){
				pd.getWriteMethod().invoke(user, 10);
				System.out.println(user.getAge());
			}
		}
	}
}
