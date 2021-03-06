package practices.heartbeat.rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RPClient<T> {

    public static <T> T getRemoteProxyObj(final Class<T> serviceInterface, final InetSocketAddress addr) {


        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface},
                (proxy, method, args) -> {
                    Socket socket = null;
                    ObjectInputStream input = null;
                    ObjectOutputStream output = null;

                    try {

                        socket = new Socket();
                        socket.connect(addr);

                        output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeUTF(serviceInterface.getName());
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);

                        input = new ObjectInputStream(socket.getInputStream());
                        return input.readObject();
                    } finally {
                        if (socket != null) socket.close();
                        if (output != null) output.close();
                        if (input != null) input.close();
                    }

                });

    }
}
