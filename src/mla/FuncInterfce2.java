package mla;

interface  funinf1{
	 void userdata();
	 void empdata();
}
 class imple implements funinf1{
	public void userdata() {
		System.out.println("overriden1");
	}
	public void empdata() {
		System.out.println("overriden1");
	}
	
}
public class FuncInterfce2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		funinf1 f1=new funinf1() {
			
			@Override
			public void userdata() {
				// TODO Auto-generated method stub
				System.out.println("overriden");
				
			}
			@Override
			public void empdata() {
				// TODO Auto-generated method stub
				System.out.println("overriden");
				
			}
			
		};
f1.userdata();
f1.empdata();
		imple i1=new imple();
		i1.userdata();
	}

}
