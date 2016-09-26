package com.pattern.builder;

import com.pattern.builder.builder.AbstractBuilder;
import com.pattern.builder.builder.ProductABuilder;
import com.pattern.builder.builder.ProductBBuilder;
import com.pattern.builder.product.AbstractProduct;

public class Director {
	private AbstractBuilder builderA = new ProductABuilder();
	private AbstractBuilder builderB = new ProductBBuilder();
	
	public AbstractProduct getProductA(){
		this.builderA.buildPart();
		return this.builderA.buildProduct();
	}
	
	public AbstractProduct getProductB(){
		this.builderB.buildPart();
		return this.builderB.buildProduct();
	}
}
