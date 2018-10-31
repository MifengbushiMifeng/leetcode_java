package practices.dynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyUtils implements InvocationHandler {

    private Object target;

    public ProxyUtils(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do before...");
        method.invoke(target, args);
        System.out.println("do after...");
        return null;
    }
}
