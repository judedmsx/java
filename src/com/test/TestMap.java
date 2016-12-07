package com.test;

import java.util.Map;
import java.util.TreeMap;

public class TestMap {
	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("a3df", "adf");
		map.put("v2gf", "vgf");
		map.put("v1af", "vaf");
		map.put("k5gj", "kgj");
		
		System.out.println(map.get("a3df"));
	}
}
