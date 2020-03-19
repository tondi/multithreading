package multithreading;

import java.util.LinkedList;

public class ProducerConsumerProblem {
	static LinkedList<Integer> list = new LinkedList<>();
	static int maxSize = 1;
	
	public static void main(String[] args) {
		Producer p1 = new Producer(list, maxSize);
		Consumer c1 = new Consumer(list, maxSize);
		
		Producer p2 = new Producer(list, maxSize);
		Consumer c2 = new Consumer(list, maxSize);
		
		Producer p3 = new Producer(list, maxSize);
		Consumer c3 = new Consumer(list, maxSize);
		
		p1.start();
		c1.start();
		
		p2.start();
		c2.start();
		
		p3.start();
		c3.start();
		
		
//		for(int i = 0; i < 10; i++) {
//		}
	
//		try {
//			p.join();
//			c.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		while(true) {
//			p.produce(list);
//			c.consume(list);
//		}
		
	}
}
