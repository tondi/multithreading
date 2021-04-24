package multithreading;

import java.util.LinkedList;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Producer extends Thread {
	LinkedList<Integer> list;
	int maxSize;
	
	public static int id = 0;
	public int _id;
	
	Producer(LinkedList<Integer> list, int maxSize) {
		this.list = list;
		this.maxSize = maxSize;
		this._id = Producer.id++;
	}
	
	@Override
	public void run() {
		while(true) {	 	
			synchronized(list) {
				while(list.size() == maxSize) {
					System.out.println("Buffer max size reached");
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				list.add(12);
				System.out.println("From producer id = " + this._id + " list.size() = " + list.size());
				list.notifyAll();
				
				long nanos = ManagementFactory.getThreadMXBean().getThreadCpuTime(Thread.currentThread().getId());
				System.out.println("Producer " + this._id + " time: " + nanos);
				try {
					sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
