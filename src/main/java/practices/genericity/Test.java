package practices.genericity;

public class Test<T> {

    private T obj;

    public Test(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void showActuallyType() {
        System.out.println("The actually type of T is " + obj.getClass().getName());
    }
}
