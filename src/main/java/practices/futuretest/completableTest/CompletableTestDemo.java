package practices.futuretest.completableTest;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CompletableTestDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        futureTest();
//        comFutureTest();
        System.out.println("----------------------------");
        comFutureTestCallback();
    }

//    private static void futureTest() throws ExecutionException, InterruptedException {
//
//        ExecutorService exe = Executors.newFixedThreadPool(5);
//
//        Future<String> result = exe.submit(() -> {
//            TimeUnit.SECONDS.sleep(3);
//            return "hello";
//        });
//
//        System.out.println("Do something");
//        System.out.println(result.get());
//        exe.shutdownNow();
//    }
//
//    private static void comFutureTest() throws ExecutionException, InterruptedException {
//        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "hello";
//        });
//        System.out.println("Do something com!");
//        System.out.println(result.get());
//    }

    private static void comFutureTestCallback() {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello";
            }
        }, executor);
        System.out.println(resultCompletableFuture.thenAcceptAsync(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t);
                System.out.println(Thread.currentThread().getName());
            }
        }, executor));
        System.out.println(123);
//        executor.
    }
}
