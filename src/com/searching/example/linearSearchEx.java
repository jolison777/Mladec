package com.searching.example;

public class linearSearchEx {

	
	    public static int searchBro(int[] arr, int target) {
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == target) {
	                return i;
	            }
	        }
	        return -1;
	    }
	 
	    public static void main(String[] args) {
	        int[] arr = {50, 10, 90, 20, 30, 70}; // fixed closing brace
	        int target = 50;
	        int index = searchBro(arr, target);
	 
	        if (index != -1) {
	            System.out.println("The target element is: " + arr[index] + " at index " + index);
	        } else {
	            System.out.println("The target not found in array lil bro");
	        }
	    }
	}
	 


