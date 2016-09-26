package com.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator implements Iterator{
	private List list = new ArrayList();
	@Override
	public boolean hasNext() {
		return list!=null&&list.size()!=0;
	}

	@Override
	public Object next() {
		return null;
	}

}
