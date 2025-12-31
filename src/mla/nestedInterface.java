package mla;

interface outer{
	public void method1();
	interface inner{
		public void method2();// this interface is not being implemeted this is the advantage of nested interface
	}
}
class calling implements outer{
	
	public void method1() {
		System.out.println("1234");
	}
	
	
}
public class nestedInterface{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calling c11=new calling();
		c11.method1();

	}

}
