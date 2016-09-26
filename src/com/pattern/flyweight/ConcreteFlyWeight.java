package com.pattern.flyweight;

public class ConcreteFlyWeight implements FlyWeight{
	private Character internalState;
	
	public ConcreteFlyWeight(Character internalState) {
		super();
		this.internalState = internalState;
	}


	@Override
	public void operation(String state) {
		System.out.println("内部状态："+internalState+" 外部状态："+state);
	}
	
}
