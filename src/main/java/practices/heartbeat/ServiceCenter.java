package practices.heartbeat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServiceCenter {

    private ExecutorService executor = Executors.newFixedThreadPool(20);

    private final ConcurrentHashMap<String, Class> serviceRegister = new
            ConcurrentHashMap<String, Class>();

    private AtomicBoolean isRunning = new AtomicBoolean(true);

    private int port = 8089;

    HeartbeatListener listener;

    private static class SingletonHolder {
        private static final ServiceCenter INSTANCE = new ServiceCenter();
    }

    public void register(Class serviceInterface, Class impl) {
        System.out.println("register service " + serviceInterface.getName());
        serviceRegister.put(serviceInterface.getName(), impl);
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        System.out.println("start server!");

        listener = HeartbeatListener.getInstance();

        while (true) {
//            executor.execute(new Server);
        }

    }

    private class ServiceTask implements Runnable {
        Socket client = null;

        public ServiceTask(Socket client) {
            this.client = client;
        }


        @Override
        public void run() {
            ObjectOutputStream output = null;
            ObjectInputStream input = null;
            try {
                input = new ObjectInputStream(client.getInputStream());
                String serviceName = input.readUTF();
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] arguements = (Object[]) input.readObject();
                Class serviceClass = serviceRegister.get(serviceName);
                if (serviceClass == null) {
                    throw new ClassNotFoundException(serviceName + " NOT found.");
                }

                Method method = serviceClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(), arguements);

                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
