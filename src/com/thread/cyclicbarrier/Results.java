package com.thread.cyclicbarrier;
/**
 * 此类会在array内保存被查找的数字在矩阵的每行里出现的次数。
 * @author maosx
 *
 */
public class Results {
	private int []data;
	
	public Results(int size){
		this.data = new int[size];
	}
	
	public void setData(int position,int value){
		this.data[position] = value;
	}
	
	public int[] getData(){
		return this.data;
	}
}
