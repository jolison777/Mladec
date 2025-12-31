package com.sorting.example;

public class BubbleSortEx {
	
	public static void sortElements(int[]arr) {
	   int n=arr.length-1;
	   int t=0;
	   for(int i=0;i<n;i++) {
		   for(int j=0;j<n-i;j++) {
			   if(arr[j]>arr[j+1]) {
				   t=arr[j];
				   arr[j]=arr[j+1];
				   arr[j+1]=t;
			   }
		   }
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
