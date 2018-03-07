package practices.genericity;

public class Test2 {

    private Object obj;

    public Test2(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }


    public void showActuallyType() {
        System.out.println("The actually type of obj is " + obj.getClass().getName());
    }
}
