package practices.heartbeat.rpc;

import practices.heartbeat.rpc.client.RPClient;
import practices.heartbeat.rpc.server.Server;
import practices.heartbeat.rpc.server.ServiceCenter;
import practices.heartbeat.rpc.service.HelloService;
import practices.heartbeat.rpc.service.HelloServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

public class PRCTest {

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Server serviceServer = new ServiceCenter(8088);
                serviceServer.register(HelloService.class, HelloServiceImpl.class);
                serviceServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        HelloService service = RPClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}
