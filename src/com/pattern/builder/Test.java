package com.pattern.builder;

import com.pattern.builder.product.AbstractProduct;
import com.pattern.builder.product.ProductA;

public class Test {
	public static void main(String[] args) {
		System.out.println("����ģ�巽��ģʽ���Ĭ�ϵĲ�ƷA");
		AbstractProduct productA = new ProductA().defaultProduct();
		
		System.out.println("\n����Director���ò�ͬ��װ��ʽ�Ĳ�ƷA"); 
	    Director director = new Director(); 
	    director.getProductA(); 
	     
	    System.out.println("\n����Director���ò�ͬ��װ��ʽ�Ĳ�ƷB"); 
	    director.getProductB(); 
	}
}
