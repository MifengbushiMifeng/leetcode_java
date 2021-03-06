package practices.concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Refer URL : https://juejin.im/post/5a3267a66fb9a045132ab988
 */
public class Horse implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private int strides = 0;

    private static Random rand = new Random(47);

    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier inBarrier) {
        barrier = inBarrier;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {

        while (!Thread.interrupted()) {
            synchronized (this) {
                strides += rand.nextInt(3);
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}
