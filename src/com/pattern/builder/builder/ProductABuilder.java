package com.pattern.builder.builder;

import com.pattern.builder.product.AbstractProduct;
import com.pattern.builder.product.ProductA;

public class ProductABuilder extends AbstractBuilder{
	private AbstractProduct productA = new ProductA();
	@Override
	public AbstractProduct buildProduct() {
		return this.productA;
	}

	@Override
	public void buildPart() {
		productA.part3();
		productA.part2();
		productA.part1();
	}

}
