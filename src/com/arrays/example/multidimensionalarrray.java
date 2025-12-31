package com.arrays.example;

public class multidimensionalarrray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1=new int[3][3];
		arr1[0][0]=102;
		int[][] arr = { {101, 102, 103}, {104, 105, 106}, {107, 108, 109} };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
			System.out.print(arr[i][j] + " ");
			} 
			System.out.println(); 
			} 
		}

	}


