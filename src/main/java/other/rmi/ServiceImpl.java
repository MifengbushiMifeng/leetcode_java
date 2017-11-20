package other.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {

    private static final long serialVersionUID = 908604997655601958L;

    protected ServiceImpl() throws RemoteException {
        super();
    }

    public String queryName(String no) throws RemoteException {

        System.out.println("hello " + no);
        return String.valueOf(System.currentTimeMillis());
    }
}
