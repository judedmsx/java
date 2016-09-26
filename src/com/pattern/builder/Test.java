package com.pattern.builder;

import com.pattern.builder.product.AbstractProduct;
import com.pattern.builder.product.ProductA;

public class Test {
	public static void main(String[] args) {
		System.out.println("利用模板方法模式获得默认的产品A");
		AbstractProduct productA = new ProductA().defaultProduct();
		
		System.out.println("\n利用Director类获得不同组装方式的产品A"); 
	    Director director = new Director(); 
	    director.getProductA(); 
	     
	    System.out.println("\n利用Director类获得不同组装方式的产品B"); 
	    director.getProductB(); 
	}
}
