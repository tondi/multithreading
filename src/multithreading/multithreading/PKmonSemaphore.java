package multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class PKmonSemaphore {
    static LinkedList<Integer> list = new LinkedList<>();
    static int maxSize = 1;

	static final int PRODUCERS = 2;
	static final int CONSUMERS = 5;

	static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        List<ProducerWithSemaphore> producers = new LinkedList<>();
        List<ConsumerWithSemaphore> consumers = new LinkedList<>();

        for (int i = 0; i < PRODUCERS; i++) {
            producers.add(new ProducerWithSemaphore(semaphore, list, maxSize));
        }

        for (int i = 0; i < CONSUMERS; i++) {
            consumers.add(new ConsumerWithSemaphore(semaphore, list));
        }

		for(ProducerWithSemaphore producer : producers) {
			producer.start();
		}

		for(ConsumerWithSemaphore consumer : consumers) {
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
