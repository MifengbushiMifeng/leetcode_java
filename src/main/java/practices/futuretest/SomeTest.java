package practices.futuretest;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class SomeTest {

    private static void test1() throws ExecutionException, InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(5);

        Future<String> result = exec.submit(

                () -> {
                    TimeUnit.SECONDS.sleep(3);
                    return "hello";
                });
        System.out.println("during the execute, still do something!");

        System.out.println(result.get());
        exec.shutdownNow();
    }

    private static void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello";
            }
        });
        System.out.println("CompletableFuture : during the execute, still do something!");
        System.out.println(result.get());

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        test1();
        test2();

    }
}
