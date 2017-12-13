package other.eightjava.future;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        Client client = new Client();

        Data data = client.request("name_future");
//        System.out.println("mock data: " + data.getResult());
        Thread.sleep(2000);

        System.out.println("real data: " + data.getResult());
    }
}
