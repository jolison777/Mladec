package com.designpattern.example;


class SingleTonTest{
	public static SingleTonTest obj;

	
	  private SingleTonTest() {//should be private so that the reference cannot be created using new key
	  
	  }
	 
	public static SingleTonTest getInstance() {//factory method
		if(obj==null) {
			obj=new SingleTonTest();
		}
		return obj;
	}
}
public class SingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingleTonTest obj1= SingleTonTest.getInstance();
		SingleTonTest obj2=SingleTonTest.getInstance();
		System.out.println(obj1.hashCode()+" "+obj2.hashCode());

	}

}
