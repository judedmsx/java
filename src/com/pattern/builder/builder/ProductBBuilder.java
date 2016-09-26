package com.pattern.builder.builder;

import com.pattern.builder.product.AbstractProduct;
import com.pattern.builder.product.ProductB;

public class ProductBBuilder extends AbstractBuilder{
	private AbstractProduct productB = new ProductB();
	@Override
	public AbstractProduct buildProduct() {
		return this.productB;
	}

	@Override
	public void buildPart() {
		productB.part3();
		productB.part2();
		productB.part1();
	}

}
