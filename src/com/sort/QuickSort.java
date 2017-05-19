package com.sort;

public class QuickSort {
	
	public static void main(String[] args) {
		int arr[] = new int[]{6,3,4,7,1};
		sort(arr,0,4);
		
		for(int i : arr){
			System.out.println(i);
		}
	}
	
	public static void sort(int arr[],int l,int h){
		if(l>h)
			return;
		int index = partition(arr, l, h);
		sort(arr,l,index-1);
		sort(arr,index+1,h);
	}
	
	public static int partition(int arr[],int l,int h){
		int temp = arr[l];
		
		while(l < h){
			while(temp<arr[h] && l < h){
				h--;
			}
			arr[l] = arr[h];
			
			while(temp>arr[l] && l < h){
				l++;
			}
			arr[h] = arr[l];
		}
		
		arr[h] = temp;
		return h;
	}
	
}
