package practices.volatiletest;

public class Test {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {

        final Test test1 = new Test();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test1.increase();
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();

        }
        System.out.print(test1.inc);
    }
}
