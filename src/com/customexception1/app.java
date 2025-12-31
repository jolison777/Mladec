package com.customexception1;

import java.util.Scanner;

public class app {

	public static void main(String[] args) throws validAgeException {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
int age=sc.nextInt();
voterData obj=new voterData();
try {
obj.checkAge(age);
}
catch(Exception e) {
	System.out.println(e.getMessage());
}
	}

}
