package com.designpattern.example;
interface BrandType{
	void anyBrandType();
}




abstract class Brands{
	protected  BrandType brand1;
	protected  BrandType brand2;
	public Brands(BrandType type1,BrandType type2) {
		this.brand1=type1;
		this.brand2=type2;
	}
	public abstract void designCompany();
}


class OfficialBrand implements BrandType{
	public void anyBrandType() {
		System.out.println("Original");
	}
}
class CopyBrand implements BrandType{
	public void anyBrandType() {
		System.out.println("Clone");
	}
}
class Apple1 extends Brands{
	public Apple1(BrandType type1,BrandType type2){
		super(type1,type2);
	}
	public void designCompany() {
		System.out.println("Apple brandd");
		brand1.anyBrandType();
		brand2.anyBrandType();
	}
}
class DellB2 extends Brands{
	public DellB2(BrandType type1,BrandType type2){
		super(type1,type2);
	}
	public void designCompany() {
		System.out.println("Dell brand");
		brand1.anyBrandType();
		brand2.anyBrandType();
	}
}

class ProdectStatus implements BrandType{
	public void anyBrandType() {
		System.out.println("Completed");
	}
}
class ProdectDelivered implements BrandType{
	public void anyBrandType() {
		System.out.println("Delivered.");
	}
}
public class BridgeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Brands obj1=new Apple1(new ProdectStatus(), new ProdectDelivered());
Brands obj2=new DellB2(new ProdectStatus(), new ProdectDelivered());
obj1.designCompany(); 
obj2.designCompany();

	}

}
