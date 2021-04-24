package multithreading;

import java.lang.management.ManagementFactory;
import java.util.LinkedList;

public class Consumer extends Thread {
	LinkedList<Integer> list;
	
	public static int id = 0;
	public int _id;
	
	Consumer(LinkedList<Integer> list) {
		this.list = list;
		this._id = Consumer.id++;
	}
	
    @Override
	public void run() {
		while(true) {
			synchronized(list) {		
				while (list.isEmpty()) {
                    System.out.println("Queue is empty, wait");
                    try {
                        list.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
				list.remove();
				System.out.println("From consumer " + this._id + " " + list.size());

				long nanos = ManagementFactory.getThreadMXBean().getThreadCpuTime(Thread.currentThread().getId());
				System.out.println("Consumer " + this._id + " time: " + nanos);
				try {
					sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				list.notifyAll();
			}
		}
	}
}
