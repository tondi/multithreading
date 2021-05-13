package multithreading;

import java.lang.management.ManagementFactory;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ConsumerWithSemaphore extends Thread {
    LinkedList<Integer> list;

    public static int id = 0;
    public int _id;
    private Semaphore _semafor;

    ConsumerWithSemaphore(Semaphore _semafor, LinkedList<Integer> list) {
        this.list = list;
        this._id = ConsumerWithSemaphore.id++;
        this._semafor = _semafor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                _semafor.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!list.isEmpty()) {
                list.remove();
            }

            System.out.println("From consumer " + this._id + " " + list.size());

            long nanos = ManagementFactory.getThreadMXBean().getThreadCpuTime(Thread.currentThread().getId());
            System.out.println("Consumer " + this._id + " time: " + nanos);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            _semafor.release();
        }
    }
}
