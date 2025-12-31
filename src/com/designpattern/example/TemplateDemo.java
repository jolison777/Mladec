package com.designpattern.example;

abstract class TemplateMethods{
	public abstract void player();
	public abstract void playerInfo();
	public final void completeteam() {
		this.player();
		this.playerInfo();
	}
	
}
class playerInfoImp extends TemplateMethods{
	public void player() {
		System.out.println("players data not added");
	}
	public void playerInfo() {
		System.out.println("Players info from Impl1");

	}
}
class playersimpl extends TemplateMethods{
	public void player() {
		System.out.println("players data from Impl2");
	}
	public void playerInfo() {
		System.out.println("Players info from Impl2");

	}
}

public class TemplateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TemplateMethods obj1=new playerInfoImp();
		TemplateMethods obj2=new playersimpl();
		obj1.completeteam();
		obj2.completeteam();

	}

}
