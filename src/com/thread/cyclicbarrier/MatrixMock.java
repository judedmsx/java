package com.thread.cyclicbarrier;

import java.util.Random;
/**
 * 此类随机生成一个在1-10之间的 数字矩阵，我们将从中查找数字。
 * @author maosx
 *
 */
public class MatrixMock {
	private int data[][];
	
	public MatrixMock(int size,int length,int number){
		data = new int[size][length];
		Random random = new Random();
		int counter = 0;
		for(int i = 0;i < size;i++){
			for(int j = 0;j < length;j++){
				data[i][j] = random.nextInt(10);
				if(data[i][j] == number){
					counter++;
				}
			}
		}
		
		System.out.println("mock : There are "+counter+" ocurrences of number "+number+" in generated data.");
	}
	
	public int[] getRow(int row){
		if(row>=0 && data.length>row){
			return data[row];
		}
		return null;
	}
}
