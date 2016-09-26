package com.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBridgeMethod {
	public static void main(String[] args) {  
		//java编译器采用bridge方法来兼容本该使用泛型的地方使用了非泛型的用法的问题。
		Class<?> clazz = S.class;  
        Method[] methods = clazz.getMethods();  
        for(Method method : methods) {  
            System.out.println(method.getName() + ":" + Arrays.toString(method.getParameterTypes()) + method.isBridge()+":"+method.getReturnType());
//        	System.out.println(method.getReturnType()+"--"+method.getReturnType().getName());
//        	System.out.println(method.getDeclaringClass());
        }
        
        System.out.println("sfd".charAt(1));
        //可以用来校验一个类是否实现指定的父类。
        System.out.println(P.class.isAssignableFrom(S.class));
        System.out.println(S.class.isAssignableFrom(P.class));
    } 
}
