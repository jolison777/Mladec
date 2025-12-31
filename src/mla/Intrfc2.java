package mla;

 class eee{
	static void kiliyan(){
	System.out.println("123");
	}
}
interface Inf2{
	public void book();
	private void color() {
		System.out.println("Private method");
	}
	static void human() {
		System.out.println("static method");
	}
	default void animal() {
		System.out.println("default method");
		color();
	}
}

class Imp2 implements Inf2{
	public void book() {
		System.out.println("book implemented");
	}
}

public class Intrfc2 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inf2 c1=new Imp2();
		c1.animal();
		Inf2.human();
		eee.kiliyan();

	}

}
