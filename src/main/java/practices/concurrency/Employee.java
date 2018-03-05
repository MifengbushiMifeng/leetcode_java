package practices.concurrency;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Employee implements Runnable {


    private String id;

    private Semaphore semaphore;

    private static Random random = new Random(47);

    public Employee(String id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(this.id + " is using the toilet");
            TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
            semaphore.release();
            System.out.println(this.id + " leaved");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
