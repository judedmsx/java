package com.sort2;
/**
 * <p>选择一个基准元素,通常选择第一个元素或者最后一个元素</p>
 * <p>通过一趟排序讲待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的 元素值比基准值大。</p>
 * <p>此时基准元素在其排好序后的正确位置</p>
 * <p>然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。</p>
 * @author maosx
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int array[] = new int[]{28,12,56,42,10,3};
		for(int a : sort(array,0,array.length-1)){
			System.out.println(a);
		}
	}
	
	public static int[] sort(int array[],int low,int high){
		if(low>high) return array;
		int index = partition(array,low,high);
		sort(array,low,index-1);
		sort(array,index+1,high);
		return array;
	}
	
	public static int partition(int array[],int low,int high){
		if(array.length>0){
			int temp = array[low];
			while(low<high){
				while(array[high]>temp&&low<high){
					high--;
				}
				array[low] = array[high];
				
				while(array[low]<temp&&low<high){
					low++;
				}
				array[high] = array[low];
			}
			array[high] = temp;
			return high;
		}
		return -1;
	}
}
