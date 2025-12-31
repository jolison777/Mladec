package com.sorting.example;

public class Selectionsortex {
	public static void sortElements(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			int minIndex=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			if(minIndex!=i) {
				int temp=arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
			
		}
		
		

	public static void main(String[] args) {
		int [] arr= {20,30,10,5,2,96,22};
		sortElements(arr);

	}

}
