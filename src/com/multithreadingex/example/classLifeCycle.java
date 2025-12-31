package com.multithreadingex.example;



public class classLifeCycle implements Runnable{
	
	public void run() {
		try {
			System.out.println("run()");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		classLifeCycle ob=new classLifeCycle();
		Thread t=new Thread(ob);
		
		
		System.out.println("before starting thread state: "+t.getState());
		System.out.println("before starting thread status: "+t.isAlive());
		t.start();
		
		
		Thread.sleep(500);
		
		
	
		System.out.println("after starting thread state: "+t.getState());
		System.out.println("after starting thread status: "+t.isAlive());
		
		t.join();
		
		
		System.out.println("after join thread state "+t.getState());
		System.out.println("after join thread state "+t.isAlive());
		
		Runnable t2=() ->{
			System.out.println("run()");
		};
		t2.run();
		
		Thread t3=new Thread(()->System.out.println("run() lambda expression"));
		t3.start();
		

	}

}
