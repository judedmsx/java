package com.sort2;

public class HeapSort {
	
	public static void main(String[] args) {
		 int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 }; 
		 heapSort(array);
		 
		 for(int a : array){
			 System.out.println(a);
		 }
	}
	
	/**
	 * 堆排序
	 * @param array
	 */
	public static void heapSort(int array[]){
		if(array==null || array.length<=1){
			return;
		}
		
		buildMaxHeap(array);
		for(int i = array.length-1;i>=0;i--){
			swap(array,0,i);
			maxHeap(array,i,0);
			
		}
	}
	
	/**
	 * 构建最大堆
	 * @param array
	 */
	public static void buildMaxHeap(int array[]){
		if(array==null || array.length<=1){
			return;
		}
		for(int i = (array.length/2);i>=0;i--){
			maxHeap(array,array.length,i);
		}
	}
	
	
	/**
	 * 维护最大堆
	 * @param array
	 * @param heapSize
	 * @param index
	 */
	public static void maxHeap(int array[],int heapSize,int index){
		int leftChild = 2*index+1;
		int rightChild = 2*index+2;
		
		int largest = index;
		
		if( leftChild < heapSize&&array[leftChild] > array[index] ){
			largest = leftChild;
		}
		
		if(rightChild < heapSize && array[rightChild] > array[largest] ){
			largest = rightChild;
		}
		
		if(largest != index){
			swap(array, largest, index);
			maxHeap(array, heapSize, largest);
		}
	}
	
	
	public static void swap(int array[],int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
