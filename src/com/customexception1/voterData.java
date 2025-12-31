package com.customexception1;


public class voterData {
	public void checkAge(int age) throws validAgeException
	{
		if(age>=18) {
			validAgeException ve=new validAgeException("valid age");
			throw(ve);
		}
		else {
			validAgeException v2=new validAgeException("not valid");
			throw(v2);
		}
		
	}

}
