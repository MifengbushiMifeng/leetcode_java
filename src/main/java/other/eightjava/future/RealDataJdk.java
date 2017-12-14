package other.eightjava.future;

import java.util.concurrent.Callable;

public class RealDataJdk implements Callable<String> {

    protected String data;

    public RealDataJdk(String data) {
        this.data = data;
    }


    public String call() throws Exception {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return data;
    }
}
