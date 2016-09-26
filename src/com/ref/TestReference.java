package com.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class TestReference {
	public static void main(String[] args) {
		String str = new String("test");
		
		ReferenceQueue<String> rq = new ReferenceQueue<String>();
		SoftReference<String> sr = new SoftReference<String>(str, rq);
		System.out.println(sr.get());
		System.gc();
		System.out.println(sr.get());
	}
}
