package practices.JCiP.Sample1;

public class Sequence {

    private int value;

    public synchronized int getNextVal() {
        return value++;
    }
}
