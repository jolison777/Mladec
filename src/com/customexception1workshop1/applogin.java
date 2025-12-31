package com.customexception1workshop1;

import java.util.Scanner;

public class applogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String pass=sc.next();
		validatermsg v1=new validatermsg();
		try {
			v1.validator(str, pass);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
