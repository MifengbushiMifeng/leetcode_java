package other.tclass;

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

    public void showType() {
        System.out.println("The actually type of T is: " + obj.getClass().getName());
    }

}
