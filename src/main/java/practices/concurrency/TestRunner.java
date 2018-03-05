package practices.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRunner {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            exec.execute(new Runner(startGate, endGate));
        }
        exec.execute(new Coach(startGate, endGate));
        exec.shutdown();

    }
}
