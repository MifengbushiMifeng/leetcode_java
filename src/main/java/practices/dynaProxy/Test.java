package practices.dynaProxy;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        ProxyUtils proxyUtils = new ProxyUtils(userService);
        UserService proxyObj = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                UserServiceImpl.class.getInterfaces(), proxyUtils);
        proxyObj.add();
    }
}
