package com.sort;

public class BubbleSort {
	public static void main(String[] args) {
		
		int array[] = new int[]{5,2,9,4,11,10};
		
		sort_2(array);
		
		for(int a : array){
			System.out.println(a);
		}
	}
	
	
	public static void sort_1(int []array){
		for(int i = 0;i < array.length;i++){
			for(int j = i+1;j < array.length;j++){
				if(array[i] < array[j]){
					int value = array[j];
					array[j] = array[i];
					array[i] = value;
				}
			}
		}
	}
	
	public static void sort_2(int []array){
		for(int i=0;i<array.length;i++){
			for(int j=array.length-1;j>i;j--){
				if(array[j] > array[j-1]){
					int value = array[j-1];
					array[j-1] = array[j];
					array[j] = value;
				}
			}
		}
	}
	
}
