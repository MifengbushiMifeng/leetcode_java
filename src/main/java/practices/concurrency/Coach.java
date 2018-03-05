package practices.concurrency;

import java.util.concurrent.CountDownLatch;

public class Coach implements Runnable {

    private final CountDownLatch startLatch;

    private final CountDownLatch endLatch;

    public Coach(CountDownLatch startLatch, CountDownLatch endLatch) {
        this.startLatch = startLatch;
        this.endLatch = endLatch;
    }


    @Override
    public void run() {
        startLatch.countDown();
        System.out.println("Coach say: Ready and GO!");
        try {
            endLatch.await();
            System.out.println("All Runners passed the point");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
