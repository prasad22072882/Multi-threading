package com.multithreading;

public class Demo1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new A();
		Thread t2 = new B();

		t1.start();
		Thread.sleep(10);
		t2.start();
	}
}

class A extends Thread {
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

class B extends Thread {
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