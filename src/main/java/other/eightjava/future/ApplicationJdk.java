package other.eightjava.future;

import java.util.concurrent.*;

public class ApplicationJdk {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<String> futureTask =
                new FutureTask<String>(new RealDataJdk("name"));

        ExecutorService executorService =
                Executors.newFixedThreadPool(1);

        executorService.submit(futureTask);

        Thread.sleep(2000);

        System.out.println("result data is: " + futureTask.get());
    }
}
