package com.pattern.builder.product;

public abstract class AbstractProduct {
	abstract public void part1();
	abstract public void part2();
	abstract public void part3();
	
	//Ĭ��ģ��
	public final AbstractProduct defaultProduct(){
		part1();
		part2();
		part3();
		return this;
	}
}
