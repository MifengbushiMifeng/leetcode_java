package practices.genericity;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionGenTestDemo {

    public static void main(String[] args) {
        CollectionGenTest<ArrayList> listTest = null;
        listTest = new CollectionGenTest<ArrayList>(new ArrayList());

        CollectionGenTest<? extends Collection> listTest2 = null;
        listTest2 = new CollectionGenTest<>(new ArrayList());

        Example e = new Example();
        e.f(" ");
        e.f(10);
        e.f(e);

    }

    static class Example {

        private <T> void f(T x) {
            System.out.println(x.getClass().getName());
        }
    }


}
