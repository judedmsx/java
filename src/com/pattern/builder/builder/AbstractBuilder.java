package com.pattern.builder.builder;

import com.pattern.builder.product.AbstractProduct;

public abstract class AbstractBuilder {
	abstract public AbstractProduct buildProduct();
	abstract public void buildPart();
}
