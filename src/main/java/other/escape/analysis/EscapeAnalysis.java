package other.escape.analysis;

public class EscapeAnalysis {

    public static B b;

    /**
     * <p>全局变量赋值发生指针逃逸</p>
     */
    public void globalVariblePointerEscape() {
        b = new B();
    }

    /**
     * <p>方法返回引用，发生指针逃逸</p>
     *
     * @return
     */
    public B methodPointerEscape() {
        return new B();
    }

    /**
     * <p>实例引用发生指针逃逸</p>
     */
    public void instancePassPointerEscape() {

        methodPointerEscape().printClassName(this);
    }

    class B {

        public void printClassName(EscapeAnalysis clazz) {
            System.out.println(clazz.getClass().getName());
        }
    }
}
