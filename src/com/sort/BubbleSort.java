package com.sort;

public class BubbleSort {
	public static void main(String[] args) {
		
		int array[] = new int[]{5,2,9,4,11,10};
		
		for(int i = 0;i < array.length;i++){
			for(int j = i+1;j < array.length;j++){
				if(array[i] < array[j]){
					int value = array[j];
					array[j] = array[i];
					array[i] = value;
				}
			}
		}
		
		for(int a : array){
			System.out.println(a);
		}
	}
	
	
}
