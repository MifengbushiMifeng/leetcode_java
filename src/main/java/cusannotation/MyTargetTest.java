package cusannotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTargetTest {

    @MyTarget("test")
    public void doSomething() {
        System.out.println("hello annotation!");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MyTargetTest.class.getMethod("doSomething", null);
        if (method.isAnnotationPresent(MyTarget.class)) {
            System.out.println(method.getAnnotation(MyTarget.class));
            method.invoke(new MyTargetTest());
        }
    }
}
