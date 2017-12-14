package other.eightjava.future;

import java.util.concurrent.*;

public class FutureTestMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<String> result = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            return "hello";
        });

        System.out.println("I will do other things during this time !");
        System.out.println("Finished !");

        System.out.println(result.get());
    }
}
