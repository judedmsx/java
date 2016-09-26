package com.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBridgeMethod {
	public static void main(String[] args) {  
		//java����������bridge���������ݱ���ʹ�÷��͵ĵط�ʹ���˷Ƿ��͵��÷������⡣
		Class<?> clazz = S.class;  
        Method[] methods = clazz.getMethods();  
        for(Method method : methods) {  
            System.out.println(method.getName() + ":" + Arrays.toString(method.getParameterTypes()) + method.isBridge()+":"+method.getReturnType());
//        	System.out.println(method.getReturnType()+"--"+method.getReturnType().getName());
//        	System.out.println(method.getDeclaringClass());
        }
        
        System.out.println("sfd".charAt(1));
        //��������У��һ�����Ƿ�ʵ��ָ���ĸ��ࡣ
        System.out.println(P.class.isAssignableFrom(S.class));
        System.out.println(S.class.isAssignableFrom(P.class));
    } 
}
