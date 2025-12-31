package com.arrays.example;

public class strngbuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 String str1="java";
 StringBuffer sb=new StringBuffer(str1);
 str1.concat("25 V");
 System.out.println(str1);
 sb.append("25 V");
 System.out.println(sb.reverse());
 System.out.println(sb.repeat("adcd", 3));
 System.out.println(str1.repeat(3 ));
 System.out.println(sb.toString());
	}

}
