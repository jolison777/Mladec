package com.designpattern.example;



abstract class UserData{
	public abstract void display();
}

class OriinalData extends UserData{
	String username;
	String password;
 String userData=username+" "+password;
	public OriinalData(String user,String pass) {
		this.password=pass;
		this.username=user;
	}
	public void display() {
		System.out.println("Original Userdata"+userData);
	}
	
}

class ProxyData extends UserData{
	private String username;
	private String password;;
	private OriinalData odata=null;
	public ProxyData(String user,String pass) {
		this.password=pass;
		this.username=user;
	}

	public void display() {
		if(odata==null) {
			odata=new OriinalData("admin","a123");
		}
		odata.display();
		}
}
public class ProxyDemo  {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
