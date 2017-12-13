package other.eightjava.future;

/**
 * The key point of the Future pattern.
 * <p>
 * Will return the 'Real Data' and has the wait process.
 */
public class FutureData implements Data {

    RealData realData = null;

    boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }

        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    public synchronized String getResult() throws InterruptedException {

        if (!isReady) {
            wait();
        }
        return realData.getResult();
    }
}
