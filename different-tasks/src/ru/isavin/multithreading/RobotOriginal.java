package ru.isavin.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RobotOriginal {
	
	public static void main(String[] args) {
		new Thread(new Foot("Right")).start();
		new Thread(new Foot("Left")).start();
	}

}

class Foot implements Runnable {
	private static Lock lock = new ReentrantLock();
	private static Condition rightStepWasMade = lock.newCondition();
	private static volatile boolean righStep;
	private final String name;
	
	public Foot(String name) {
		this.name = name;
	}
	
	public void run() {
		for (;;) {
			step();
		}
	}
	
	private void step() {
//		synchronized (Foot.class) {
//	        if ("Right".equals(name)) {
//	        	while (!righStep) {
//	        		try {
//	        			Foot.class.wait();
//	        		} catch(InterruptedException e) {
//	        			e.printStackTrace();
//	        		}
//	        	}
//	        } else {
//	        	while (righStep) {
//	        		try {
//	        			Foot.class.wait();
//	        		} catch(InterruptedException e) {
//	        			e.printStackTrace();
//	        		}
//	        	}
//	        }
//	        System.out.println(name + " step");
//	        righStep = !righStep;
//	        Foot.class.notify();
//        }
		if (lock.tryLock()) {
			try {
				if ("Right".equals(name)) {
					if (!righStep) {
						try {
	                        rightStepWasMade.await();
                        } catch (InterruptedException e) {
	                        e.printStackTrace();
                        }
					}
				} else {
					if (righStep) {
						try {
	                        rightStepWasMade.await();
                        } catch (InterruptedException e) {
	                        e.printStackTrace();
                        }
					}
				}
				System.out.println(name + " step");
				righStep = !righStep;
				rightStepWasMade.signal();
//				lock.unlock();
			} finally {
				lock.unlock();
			}
		}
	}
}
