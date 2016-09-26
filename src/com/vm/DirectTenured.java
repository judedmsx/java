package com.vm;

/**
 * vm������-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 */
public class DirectTenured {
	private static final int _1MB = 1024*1024;
	public static void main(String[] args) {
		byte [] allocation;
		allocation = new byte[4*_1MB];
		allocation = null;
	}
}
