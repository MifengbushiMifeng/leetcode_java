package practices.futuretest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureCook {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long startTime = System.currentTimeMillis();

        // Step 1 : online shopping for kitchenware
        Callable<Kitchenware> online = new Callable<Kitchenware>() {
            @Override
            public Kitchenware call() throws Exception {
                System.out.println("1 : order!");
                System.out.println("1 : Wait for shipping!");

                Thread.sleep(5000);

                System.out.println("1 : shipped!");

                return new Kitchenware();

            }
        };
        FutureTask<Kitchenware> task = new FutureTask<Kitchenware>(online);
        new Thread(task).start();

        // Step2 : go to supermarket for food.
        // mock for the process of shopping for food.
        Thread.sleep(2000);
        Food food = new Food();
        System.out.println("2 : food is ready!");

        // Step 3 : cook
        if (!task.isDone()) {
            System.out.println("3 : waiting for kitchenware!");
        }

        Kitchenware kitchenware = task.get();
        System.out.println("3 : kitchenware and food are ready, start to cook!");

        cook(kitchenware, food);

        System.out.println("Total time cost : " + (System.currentTimeMillis() - startTime) + "ms");

    }

    static void cook(Kitchenware kitchenware, Food food) {
    }

    static class Kitchenware {
    }

    static class Food {
    }
}
