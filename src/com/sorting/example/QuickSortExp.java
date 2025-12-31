package com.sorting.example;


import java.util.Arrays;
 
public class QuickSortExp {
 
	public static void sortElements(int arr[], int l, int h) {
		if(l < h) {
			int pi = splitArray(arr, l, h);
			
			sortElements(arr, l, pi-1);
			
			sortElements(arr, pi+1, h);
		}
	}
	public static int splitArray(int [] arr, int l, int h) {
		int pivot = arr[h];
		
		int i = (l - 1);
		
		for(int j=l;j<h;j++) {
			if(arr[j] <= pivot) {
				i++;
				
				swapElements(arr, i, j);
			}
		}
		
		swapElements(arr, i+1, h);
		
		return i+1;
	}
	
	public static void swapElements(int []arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
 
	public static void main(String[] args) {
		
		int [] arr = {3,7,8,5,2,1,9,5,4};
		
		System.out.println("before sorting :"+ Arrays.toString(arr));
		
		sortElements(arr, 0, arr.length-1);
		
		System.out.println("after sorting :"+Arrays.toString(arr));
	}
}
 