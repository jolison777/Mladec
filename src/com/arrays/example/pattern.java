package com.arrays.example;

import java.util.regex.Pattern;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String str="java";
System.out.println(Pattern.matches(str, "java"));
System.out.println(Pattern.matches("[a-zA_Z]","a"));
String pwdptrn="^(?=.*[a-z])(?=.*[A-Z](?+=*[0-9])(?=*[]!@#$%^&89)";
	}

}
