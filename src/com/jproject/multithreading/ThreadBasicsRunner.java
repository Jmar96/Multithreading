package com.jproject.multithreading;

class Task1 extends Thread {
	public void run() {
		System.out.print("Task1 Started Running ");
		for (int i = 101; i <= 199; i++) {
			System.out.print("/" + i + "/ ");
		}
		System.out.println();
		System.out.println("Task1 Done");
	}
}

class Task2 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.print("Task2 Started Running ");
		for (int i = 201; i <= 299; i++) {
			System.out.print("(" + i + ") ");
		}
		System.out.println();
		System.out.println("Task2 Done");
	}
}

class Task4 implements Runnable {
	private int from;
	private int to;

	public Task4(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.print("Task4 Started Running ");
		for (int i = this.from; i <= this.to; i++) {
			System.out.print("[" + i + "] ");
		}
		System.out.println();
		System.out.println("Task4 Done");
	}

}

public class ThreadBasicsRunner {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println();

		// Task1
		Task1 task1 = new Task1();
		task1.setPriority(1);
		task1.start();

		// Task2
		Task2 task2 = new Task2();
		Thread task2Thread = new Thread(task2);
		task2Thread.setPriority(9);
		task2Thread.start();

		//wait for task1 to complete before Task3 will start
		task1.join();

		//wait for task2 to complete before Task3 will start
		task2Thread.join();
				
		// Task3
		System.out.print("Task3 Started Running ");
		for (int i = 301; i <= 399; i++) {

			System.out.print("{" + i + "} ");
		}
		System.out.println();
		System.out.println("Task3 Done");


		// Task4
		Thread t4 = new Thread(new Task4(401, 500));
		t4.setPriority(10);
		t4.start();
		
	}

}
