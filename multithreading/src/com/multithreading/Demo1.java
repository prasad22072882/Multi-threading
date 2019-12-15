package com.multithreading;

public class Demo1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("A " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("B " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		System.out.println("t1 is alive: " + t1.isAlive());
		System.out.println("t2 is alive: " + t2.isAlive());
		
		t1.start();
		Thread.sleep(10);
		t2.start();
		Thread.sleep(10);

		System.out.println("t1 is alive: " + t1.isAlive());
		System.out.println("t2 is alive: " + t2.isAlive());

		t1.join();
		t2.join();
		System.out.println("t1 is alive: " + t1.isAlive());
		System.out.println("t2 is alive: " + t2.isAlive());

		System.out.println("All process is completed."); // executed by main thread.
	}
}
