package com.sort;

public class InsertSort {
	
	public static int[] sort(int[] array){
		if(array.length>0){
			int k,temp;
			for(int i = 1;i < array.length;i++){
				k = i;
				temp = array[i];
				while(k > 0 && array[k-1]>temp){
					array[k] = array[k-1];
					k--;
				}
				array[k] = temp;
			}
		}
		return array;
	}
	
	public static int[] sort2(int[] array){
		if(array.length > 0){
			int k,temp;
			for(int i = 1;i < array.length;i++){
				k = i - 1;
				temp = array[k+1];
				while(k >= 0 && array[k] < temp){
					array[k+1] = array[k];
					k--;
				}
				array[k+1] = temp;
			}
		}
		return array;
	}
	
	
	public static void main(String[] args) {
		for(int a :sort2(new int[]{29,11,9,45,12,85})){
			System.out.println(a);
		}
	}
}
