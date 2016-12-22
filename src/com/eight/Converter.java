package com.eight;

@FunctionalInterface
public interface Converter<F,T> {
	T convert(F from);
}
