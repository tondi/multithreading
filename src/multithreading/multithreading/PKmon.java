package multithreading;

import java.util.LinkedList;
import java.util.List;

public class PKmon {
    static LinkedList<Integer> list = new LinkedList<>();
    static int maxSize = 1;

	static final int PRODUCERS = 5;
	static final int CONSUMERS = 2;

    public static void main(String[] args) {
        List<Producer> producers = new LinkedList<>();
        List<Consumer> consumers = new LinkedList<>();

        for (int i = 0; i < PRODUCERS; i++) {
            producers.add(new Producer(list, maxSize));
        }

        for (int i = 0; i < CONSUMERS; i++) {
            consumers.add(new Consumer(list));
        }

		for(Producer producer : producers) {
			producer.start();
		}

		for(Consumer consumer : consumers) {
			consumer.start();
		}

//
//		try {
//			p.join();
//			c.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		while(true) {
//			p.produce(list);
//			c.consume(list);
//		}

    }
}
