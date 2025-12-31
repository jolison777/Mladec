package com.arrays.example;

import java.util.concurrent.atomic.DoubleAdder;

public class Stringss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="hello";
	    String b="hello";
	    String e="java";
	    String c= new String("hello");
	    String d=new String("hello");
	
	    String s1="hello";//102
	    System.out.println(s1);
	    s1.concat("Hi byeee");
	    System.out.println(s1);
	    s1=s1.concat("Hiii");//different address in scp 103
	    System.out.println(s1);

	}

}
