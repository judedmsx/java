package com.effective.singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Elvis implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final Elvis INSTANCE = new Elvis();
	
	private Elvis(){
		//防止反射机制 创建对象
		if(INSTANCE != null){
			throw new IllegalArgumentException("no exist the second Instance");
		}
	}
	
	public static Elvis getInstance(){
		return INSTANCE;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Elvis elvis = Elvis.INSTANCE;
		Elvis elvis1 = null;
		for(Constructor constructor : elvis.getClass().getDeclaredConstructors()){
			constructor.setAccessible(true);
			elvis1 = (Elvis)constructor.newInstance();
		}
		System.out.println(elvis == elvis1);
		System.out.println("----");
	}
}
