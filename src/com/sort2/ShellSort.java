package com.sort2;
/**
 * <p>先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。</p>
 * @author maosx
 *
 */
public class ShellSort {
	public static void main(String[] args) {
		int array[] = new int[]{28,12,56,42,10,3};
		for(int a : sort(array)){
			System.out.println(a);
		}
	}
	
	
	public static int[] sort(int array[]){
		if(array.length>0){
			int gap = array.length/2;
			int k,temp;
			while(gap>=1){
				for(int i=gap;i<array.length;i++){
					temp = array[i];
					for(k=i-gap;k>=0&&array[k]>temp;k=k-gap){
						array[k+gap] = array[k];
					}
					array[k+gap] = temp;
				}
				gap = gap/2;
			}
			
		}
		return array;
	}
}
