package other.idearefactor;

public class Refactor {

    private double quantity;

    private double itemPrice;

    public double count() {

        if (basePrice() > 1000) {
            return basePrice() * 0.95;
        } else {
            return basePrice() * 0.98;
        }
    }

    private double basePrice() {
        return quantity * itemPrice;
    }

    public void aMethod() {
        String str = "str";
        System.out.println(aString(str));
    }

    private String aString(String str) {
        return returnString().concat(str);
    }

    public String returnString() {
        return "123";
    }
}
