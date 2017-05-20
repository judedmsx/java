package com.sort2;
/**
 * <p>在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。</p>
 * <p>即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。</p>
 * @author maosx
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int array[] = new int[]{28,12,56,42,10,3};
		for(int a : sort(array)){
			System.out.println(a);
		}
	}
	public static int[] sort(int array[]){
		if(array.length>0){
			for(int i=0;i<array.length;i++){
				for(int j=array.length-1;j>i;j--){
					if(array[i]>array[j]){
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
		}
		
		return array;
	}
}
