package com.sort2;

/**
 * <p>将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。</p>
 * <p>即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。</p>
 * @author maosx
 *
 */
public class InsertionSort {
	public static void main(String[] args) {
		int array[] = new int[]{28,12,56,42,10,3};
		
		for(int a : sort(array)){
			System.out.println(a);
		}
	}
	
	public static int[] sort(int array[]){
		if(array.length>0){
			int k,temp;
			for(int i=1;i<array.length;i++){
				k = i-1;
				temp = array[k+1];
				while(k>=0 && array[k] > temp){
					array[k+1] = array[k];
					k--;
				}
				array[k+1] = temp;
			}
			
		}
		return array;
	}
}
