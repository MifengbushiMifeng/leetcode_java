package practices.futuretest;

public class CommonCook {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        // Step 1 : online shopping for kitchenware
        OnlineShopping thread = new OnlineShopping();
        thread.start();
        // make sure the kitchenware id ready!
        thread.join();

        // Step 2 : go to supermarket for food
        Thread.sleep(2000);
        Food food = new Food();
        System.out.println("2 : Food is ready!");

        // Step 3 : Cook with kitchenware and food.
        System.out.println("3 : Start to cook!");
        cook(thread.kitchenware, food);
        System.out.println("Total time cost : " + (System.currentTimeMillis() - startTime) + "ms");


    }

    /**
     * Online shopping for kitchenware.
     */
    static class OnlineShopping extends Thread {

        private Kitchenware kitchenware;

        @Override
        public void run() {
            System.out.println("1 : Order!");
            System.out.println("1 : Wait for shipping!");

            try {
                // mock the process of shipping
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1 : The kitchenware is shipped!");
            kitchenware = new Kitchenware();
        }

    }

    static void cook(Kitchenware kitchenware, Food food) {
    }

    static class Kitchenware {
    }

    static class Food {
    }

}
