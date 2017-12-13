package other.eightjava.future;

public class RealData implements Data {

    protected String data;

    public RealData(String data) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.data = data;

    }

    public String getResult() throws InterruptedException {
        return data;
    }
}
