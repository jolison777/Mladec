package com.sorting.example;

public class InserstionSort {
	public static void sortElements(int[]arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			int k=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>k) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=k;
		}
		 for(int i=0;i<n;i++) {
				System.out.print(arr[i]+" ");
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {20,-5,30,10,5,2,96,22};
		sortElements(arr);
	}

}
