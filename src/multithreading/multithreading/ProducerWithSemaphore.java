package multithreading;

import java.lang.management.ManagementFactory;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ProducerWithSemaphore extends Thread {
    private Semaphore _semafor;
    LinkedList<Integer> list;
    int maxSize;

    public static int id = 0;
    public int _id;

    public ProducerWithSemaphore(Semaphore _semafor, LinkedList<Integer> list, int maxSize) {
        this._semafor = _semafor;
        this.list = list;
        this.maxSize = maxSize;
        this._id = Producer.id++;
    }

    @Override
    public void run() {

        while(true) {

            try {
                _semafor.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(list.size() != maxSize) {
                list.add(12);
            }

            System.out.println("From producer id = " + this._id + " list.size() = " + list.size());

            long nanos = ManagementFactory.getThreadMXBean().getThreadCpuTime(Thread.currentThread().getId());
            System.out.println("Producer " + this._id + " time: " + nanos);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            _semafor.release();
        }
    }
}
