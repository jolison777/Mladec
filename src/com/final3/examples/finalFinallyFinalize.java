package com.final3.examples;

public class finalFinallyFinalize implements AutoCloseable{
     private int objId;
    
	
	
	public finalFinallyFinalize(int objId) {
		this.objId = objId;
		System.out.println("Object created "+objId);
	}

	public void finalize() throws Throwable {
		try {
			System.out.println("object released (garbage collection)");
		}
		finally {
			super.finalize();
		}
	}
	
	public void close() {
		System.out.println("closing resources.");
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		finalFinallyFinalize obj1=new finalFinallyFinalize(1);
		finalFinallyFinalize obj2=new finalFinallyFinalize(2);
		obj1=null;
		obj2=null;
		Runtime.getRuntime().gc();
		System.gc();
		Thread.sleep(2000);
		System.out.println("Main method end");

	}

}
