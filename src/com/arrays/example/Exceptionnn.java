package com.arrays.example;

public class Exceptionnn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//System.out.println(10/0);
		int[]arr= {1,2,3};
		System.out.println(arr[3]);
		String str=null;
		System.out.println(str.charAt(5));
		int x=Integer.parseInt("11.00");
		}
		/*
		 * catch(ArithmeticException e){ System.out.println(e.getMessage()); }
		 */
		catch(Exception e) {
		//System.out.println(e.getMessage()); 
			e.printStackTrace();
			System.out.println(e); 
		}

	}

}
