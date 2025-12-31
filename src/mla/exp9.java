package mla;


public class exp9 {
	static int pincode=234234;
    int atmpin=3030;
	public exp9() {
		System.out.println("contructor");
	}
	static {
		System.out.println("static block"+pincode);
	}
	 
	{
		System.out.println("instant block"+atmpin);
	}
	public static exp9 getExp9(){
		return new exp9();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//exp9 e1=new exp9();
	exp9 e2 = exp9.getExp9();
	}

}
