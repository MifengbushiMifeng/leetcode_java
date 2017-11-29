package other.idearefactor;

public class Extract2 {

    public void method() {
        int one = 1;
        int two = 2;
        int three = add(one, two);
        int four = add(one, three);
    }

    private int add(int one, int two) {
        return one + two;
    }

    private boolean getPrice(double basePriceIn){
        return (basePriceIn > 1000);
    }
}
