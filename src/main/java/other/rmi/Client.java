package other.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {

        Registry registry = null;

        try {

            registry = LocateRegistry.getRegistry("127.0.0.1", 8088);

            String[] list = registry.list();
            for (String s : list) {
                System.out.println(s);

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        try {
            IService service = (IService) registry.lookup("vince");
            String result = service.queryName("ha ha ha");
            System.out.println("result from remote: " + result);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
