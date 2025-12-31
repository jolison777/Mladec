package com.multithreadingex.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskScheduleDemo {

	static class Systemtask implements Runnable{
		public void run() {
			System.out.println("running background task running...");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
       scheduler.scheduleAtFixedRate(new Systemtask(), 0, 5, TimeUnit.SECONDS);
	}

}
