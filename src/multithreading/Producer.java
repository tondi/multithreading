package multithreading;

import java.util.LinkedList;

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
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				list.add(12);
				System.out.println("From prod " + this._id + " " + list.size());
				list.notifyAll();
				
//				try {
//					sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}
}
