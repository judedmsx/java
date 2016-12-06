package com.sort;

public class SelectionSort {
	public static int[] sort(int []array){
		if(array.length > 0){
			for(int i=0;i<array.length;i++){
				int index = i;
				for(int j=i+1;j<array.length;j++){
					if(array[index]>array[j])
						index = j;
				}
				
				int temp=array[i];
				array[i]=array[index];
				array[index]=temp;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		for(int a:sort(new int[]{9,1,2,5,7,4,8,6,3,5})){
			System.out.println(a);
		}
	}
}
