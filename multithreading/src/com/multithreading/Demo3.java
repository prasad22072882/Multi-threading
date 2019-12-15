package com.multithreading;

public class Demo3 {
	public static void main(String[] args) {
		P p = new P();
		new Producer(p);
		new Consumer(p);
	}
}

class P {
	int num;
	boolean valueSet = false;

	public synchronized void put(int num) throws InterruptedException {
		while (valueSet) {
			wait(); // wait() always works if the method is thread safe
		}
		System.out.println("put: " + num);
		this.num = num;
		valueSet = true;
		notify();
	}

	public synchronized void get() throws InterruptedException {
		while (!valueSet) {
			wait();
		}
		System.out.println("get: " + num);
		valueSet = false;
		notify();
	}
}

class Producer implements Runnable {
	P p;

	public Producer(P p) {
		this.p = p;
		Thread t = new Thread(this, "Producer");
		t.start();
	}

	public void run() {
		int i = 0;
		while (true) {
			try {
				p.put(i++);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	P p;

	public Consumer(P p) {
		this.p = p;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}

	public void run() {
		while (true) {
			try {
				p.get();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}