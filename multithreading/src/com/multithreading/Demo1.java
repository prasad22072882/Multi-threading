package com.multithreading;

public class Demo1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new A());
		Thread t2 = new Thread(new B());

		t1.start();
		Thread.sleep(10);
		t2.start();
	}
}

class A implements Runnable {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("A " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class B implements Runnable {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("B " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}