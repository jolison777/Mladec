package mla;

public class constctr {
	int id;
	String name;
	String emp;
	public constctr(int id, String name, String emp) {
		
		  this.id = id; this.name = name; this.emp = emp;
		 
		System.out.println( "parameterized");
	}
	public constctr() {
		System.out.println("default");
	}
	public constctr(int id, String name) {
		System.out.println("overloaded");
	}
	public constctr(constctr ctr) {
		System.out.println(ctr.name);
	}
	
	public static void main(String[]args) {
		constctr c1=new constctr(1,"dhoni");
		constctr c2= new constctr();
		constctr c3=new constctr(1,"kholi","Rcb");
		constctr c4=new constctr(c3);
		
	}

}
