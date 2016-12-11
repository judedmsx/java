package com.sort;

public class RecursiveMergeSort {
	
	public static void main(String[] args) {  
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
        print(data);  
        sort(data);  
    }  
	
	
	public static void sort(int []array){
		mergeSort(array, 0, array.length-1);
	}
	
	/**
	 * 
	 * �ϲ�����           .<br>
	 *  void
	 */
	public static void merge(int []array,int left,int center,int right){
		int []temp = new int[array.length];
		
		//������������һ��Ԫ���±�
		int tmp=left;
		//�Ҳ������һ��Ԫ���±� 
		int middle=center+1;
		//��ʱ�����һ��Ԫ���±�
		int index=left;
		while(left<=center && middle<=right){
			if(array[left]<array[middle]){
				temp[index++]=array[left++];
			}else{
				temp[index++]=array[middle++];
			}
		}
		
		while(left<=center){
			temp[index++]=array[left++];
		}
		while(middle<=right){
			temp[index++]=array[middle++];
		}
		
		while(tmp<=right){
			array[tmp]=temp[tmp++];
		}
		
		print(array);
	}
	
	/**
	 * 
	 * �ֽ�����           .<br>
	 *
	 * @param a
	 * @param b
	 * @param p
	 * @param q  void
	 */
	public static void mergeSort(int []array,int left,int right){
		if(left >= right)
			return;
		
		int center = (left+right)/2;
		
		mergeSort(array,left,center);
		
		mergeSort(array,center+1,right);
		
		merge(array,left,center,right);
	}
	
	public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + "\t");  
        }  
        System.out.println();  
    }  
}
