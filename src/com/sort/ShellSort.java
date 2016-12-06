package com.sort;

public class ShellSort {
	
	public static int[] sort(int []array){
		if(array.length > 0){
			int gap = array.length/2;
			
			while(gap>=1){
				for(int i=gap;i<array.length;i++){
					int j = 0,temp=array[i];
					for(j = i-gap;j>=0&&array[j]>temp;j=j-gap){
						array[j+gap] = array[j];
					}
					array[j+gap] = temp;
				}
				printAll(array);
				gap = gap/2;
			}
		}
		return array;
	}
	
	public static void printAll(int []array){
		for(int a : array){
			System.out.print(a+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		sort(new int[]{9,1,2,5,7,4,8,6,3,5});
		
	}
}
