package practices.heartbeat.rpc.service;

public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "Hi " + name;
    }
}
