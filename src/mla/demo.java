package mla;

 interface Inf1 {
	float k=3.14f;
	void cat();

}

abstract class Abs{
	public abstract void disp();
	public void show() {
		System.out.println("Implemented method from abs");
	}
}
class Imp1 extends Abs implements Inf1{
         public void disp() {
        	 System.out.println("abs method override"+k);
         }
         public void cat() {
        	 System.out.println("inf method overried" );
         }
}

public class demo{
	public static void main (String[]args) {
		
		Imp1 obj1=new Imp1();
		obj1.cat();
		obj1.show();
		obj1.disp();
	
	}
	
}