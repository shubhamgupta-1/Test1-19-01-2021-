package com.question2;

import java.util.Random;

/*
 * Q2. Write a program that runs 5 threads, each thread randomizes a number
between 1 and 10. The main thread waits for all the others to finish, calculates
the sum of the numbers which were randomized and prints that sum. You will
need to implement a Runnable class that randomizes a number and store it in a
member field. When all the threads have done, your main program can go over
all the objects and check the stored values in each object.
*/

class Job implements Runnable {
	Random random = new Random();
	private int sum;

	private boolean isDone = false;
	int c = 0;

	@Override
	public void run() {
		int r = random.nextInt(10) + 1;
		System.out.println(Thread.currentThread().getName()+": "+ r);
		c++;
		sum = sum + r;
		if (c == 5) {
			isDone = true;
			synchronized (this) {
				notifyAll();
			}
		}
	}

	public synchronized int getSum() {
		if (!isDone) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
}

public class Question2 {
	public static void main(String[] args) {
		Job job = new Job();

		Thread t1 = new Thread(job, "T1");
		Thread t2 = new Thread(job, "T2");
		Thread t3 = new Thread(job, "T3");
		Thread t4 = new Thread(job, "T4");
		Thread t5 = new Thread(job, "T5");

		t1.start(); t2.start(); t3.start(); t4.start(); t5.start();

		try {
			t1.join(); 	t2.join();
			t3.join();	t4.join();
			t5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("sum: " + job.getSum());
		System.out.println("Main Thread Fininshed");
	}
}
