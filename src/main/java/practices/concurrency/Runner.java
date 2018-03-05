package practices.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Runner implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private static Random rand = new Random(47);

    private final CountDownLatch startLatch;

    private final CountDownLatch endLatch;

    public Runner(CountDownLatch startLatch, CountDownLatch endLatch) {
        this.startLatch = startLatch;
        this.endLatch = endLatch;
    }

    @Override
    public void run() {
        try {
            startLatch.await();
            doWork();
            endLatch.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + "completed!");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);

    }
}
