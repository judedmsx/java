package com.sort;

public class BinarySearchSort {
	
	public static void main(String[] args) {
		int array[] = new int[]{5,2,9,4,11,10};
		System.out.println(sort(array,11));
	}
	
	public static int sort(int []array,int goal){
		int left = 0;
		int right = array.length-1;
		
		int m;
		while(right>0){
			m = (right+left)>>1;
			if(array[m] == goal)
				return m;
			else if(array[m]<goal)
				left=m+1;
			else
				right=m-1;
		}
		
		return -1;
	}
}
