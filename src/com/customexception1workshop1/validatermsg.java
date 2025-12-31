package com.customexception1workshop1;

public class validatermsg {

	public void validator (String name,String pass) throws passingMsg{
		if(name.equals("Dhoni") && pass.equals("12345678")) {
			passingMsg msg=new passingMsg("Credentials correct");
			throw msg;
		}
		else{
			passingMsg msg=new passingMsg("Credentials Incorrect");
			throw msg;
		}
	}
}
