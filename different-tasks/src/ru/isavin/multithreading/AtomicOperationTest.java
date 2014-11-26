package ru.isavin.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Реализовать getAndIncrement() на основе compareAndSet()
 * @author ilasavin
 *
 */
public class AtomicOperationTest {
	
	private AtomicInteger value;

	public AtomicOperationTest(int intValue) {
	    this.value = new AtomicInteger(intValue);
    }
	
	public int getAndIncrement() {
		while (true) {
			int current = value.get();
			int next = current + 1;
			
			if (value.compareAndSet(current, next)) {
				return current;
			}
		}
	}
	
	public static void main(String args[]) {
		final AtomicOperationTest at = new AtomicOperationTest(0);
		List<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < 1000; i++) {
			threads.add(new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(at.getAndIncrement());
					
				}
			}));
		}
		
		for (Thread thread : threads) {
			thread.start();
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(2);
		pq.add(5);
		pq.add(56);
		pq.add(3);
		System.out.println(pq);
	}
}
