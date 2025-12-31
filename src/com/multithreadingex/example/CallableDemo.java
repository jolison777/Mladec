package com.multithreadingex.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SmipleMaths implements Callable<Integer>
{
	private final int count;
    

	public SmipleMaths(int count) {
		this.count = count;
	}


	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		
		int add=0;
		for(int i=1;i<=count;i++) {
			add+=i;
			Thread.sleep(500);
		}
		System.out.println("The count value is "+add+" "+Thread.currentThread().getName());
		return add;
	}
	
}

public class CallableDemo {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor=Executors.newSingleThreadExecutor();
		SmipleMaths task =new SmipleMaths(10);
		Future<Integer> future=executor.submit(task);
		System.out.println("Task submitted.");
		try {
			int rslt =future.get();
			System.out.println("the result from the callable task: ");
		}
		catch(InterruptedException | ExecutionException e) 
		{
			e.printStackTrace();
		}
		executor.shutdown();
	}

}
