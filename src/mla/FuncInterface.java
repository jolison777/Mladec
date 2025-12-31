package mla;

interface FunInf{
	String greetUser(String message);
	static void cat() {
		System.out.println("Cat walks");
	}
	default void dog() {
		System.out.println("Dog runs");
	}
	private void fox() {
		System.out.println("fox to nothing");
	}
}
public class FuncInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunInf obj=(String msg)->{
			System.out.println("funinf overrided");
			return msg;
		};
		System.out.println(obj.greetUser("Hi hello....."));
	}

	}


