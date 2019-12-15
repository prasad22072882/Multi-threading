package com.multithreading;

public class Demo1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			System.out.println("priority of t1: " + Thread.currentThread().getPriority()); // get the priority of thread and default priority is 5 or NORM_PRIORITY
			for (int i = 1; i <= 5; i++) {
				System.out.println("A " + i);
				try {
					Thread.sleep(1000); // thread will sleep for 1000 milliseconds(1 second)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "thread name");
		Thread t2 = new Thread(() -> {
			System.out.println("priority of t2: " + Thread.currentThread().getPriority());
			for (int i = 1; i <= 5; i++) {
				System.out.println("B " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.setPriority(Thread.MIN_PRIORITY); //set the priority thread
		t2.setPriority(10); // set the priority of thread
		
		System.out.println("priority of t1: " + t1.getPriority());
		System.out.println("priority of t2: " + t2.getPriority());

		System.out.println("t1 is alive: " + t1.isAlive()); // check the thread is in running state or not
		System.out.println("t2 is alive: " + t2.isAlive());
		
		System.out.println("Name of thread t1: " + t1.getName()); // get the name of the thread
		System.out.println("Name of thread t2: " + t2.getName());
		
		t1.setName("I am thread-1"); // set a particular thread name
		t2.setName("I am thread-2");
		
		System.out.println("Name of thread t1: " + t1.getName());
		System.out.println("Name of thread t2: " + t2.getName());
		
		t1.start();
		Thread.sleep(10); // thread will sleep for 10 milliseconds
		t2.start();
		Thread.sleep(10);

		System.out.println("t1 is alive: " + t1.isAlive());
		System.out.println("t2 is alive: " + t2.isAlive());

		t1.join(); // main thread will wait for t1 thread to finish his work
		t2.join();
		System.out.println("t1 is alive: " + t1.isAlive());
		System.out.println("t2 is alive: " + t2.isAlive());

		System.out.println("All process is completed."); // executed by main thread.
	}
}
