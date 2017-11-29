package other.idearefactor;

public class Extract {


    private String name;

    public void printOwing(double amount) {

        printBanner();
        printDetails(amount);
    }

    private void printDetails(double amount) {
        System.out.println("name:" + this.name);
        System.out.println("amount:" + amount);
    }

    private void printBanner() {
    }
}
