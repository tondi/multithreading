package multithreading;

import java.util.LinkedList;

public class Consumer extends Thread {
	LinkedList<Integer> list;
	
	public static int id = 0;
	public int _id;
	
	Consumer(LinkedList<Integer> list, int maxSize) {
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
                list.notifyAll();
			}
		}
	}
}
