package other.rmi;

import java.rmi.RemoteException;

public interface IService {

    public String queryName(String no) throws RemoteException;
}
