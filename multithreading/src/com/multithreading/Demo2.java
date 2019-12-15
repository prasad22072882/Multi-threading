package com.multithreading;

public class Demo2 {
	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 1000; i++) {
				c.count();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 1000; i++) {
				c.count();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println(c.count);
	}
}

class Counter {
	int count;

	public synchronized void count() { // synchronized keyword used for thread safe
		count++;
	}
}