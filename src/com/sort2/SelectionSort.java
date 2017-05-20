package com.sort2;
/**
 * <p>在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；</p>
 * <p>然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换。</p>
 * <p>依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。</p>
 * @author maosx
 *
 */
public class SelectionSort {
	public static void main(String[] args) {
		int array[] = new int[]{28,12,56,42,10,3};
		for(int a : sort(array)){
			System.out.println(a);
		}
	}
	
	public static int[] sort(int array[]){
		if(array.length>0){
			for(int i=0;i<array.length;i++){
				int k = i;
				for(int j=i+1;j<array.length;j++){
					if(array[k] > array[j]){
						k = j;
					}
				}
				if(k!=i){
					int temp = array[i];
					array[i] = array[k];
					array[k] = temp;
				}
			}
		}
		return array;
	}
}
