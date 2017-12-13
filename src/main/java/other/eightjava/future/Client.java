package other.eightjava.future;

/**
 * return a future data.
 * create a new thread and return the real data.
 */
public class Client {

    public Data request(final String inStr) {

        final FutureData futureData = new FutureData();

        new Thread(new Runnable() {

            public void run() {
                RealData realData = new RealData(inStr);
                futureData.setRealData(realData);
            }
        }).start();

        return futureData;
    }
}
