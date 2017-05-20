package com.sort2;

public class BinarySearch {
	public static void main(String[] args) {
		int array[] = new int[]{5,2,9,4,11,10};
		System.out.println(binarySearch(array,11));
	}
	
	
	public static int binarySearch(int array[],int v){
		int left = 0;
		int right = array.length-1;
		while(right>0){
			int m = (right+left)/2;
			
			if(array[m] == v)
				return m;
			else if(array[m] > v)
				right=m-1;
			else
				left=left+1;
		}
		return -1;
	}
}
