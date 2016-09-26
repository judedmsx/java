package com.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CompositeFlyWeight implements FlyWeight{
	private Map<Character,FlyWeight> files = new HashMap<Character,FlyWeight>();
	
	public void add(Character c,FlyWeight fly){
		files.put(c, fly);
	}
	
	
	@Override
	public void operation(String state) {
		for(FlyWeight fly:files.values()){
			fly.operation(state);
		}
	}

}
