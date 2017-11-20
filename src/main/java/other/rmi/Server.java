package other.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {

        Registry registry = null;

        try {
            registry = LocateRegistry.createRegistry(8088);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        try {
            ServiceImpl service = new ServiceImpl();
            registry.rebind("vince", service);
            System.out.println("bing server");
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
