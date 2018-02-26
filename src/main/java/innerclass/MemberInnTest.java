package innerclass;

public class MemberInnTest {

    private String member = "This is outer member";

    class B {
        public B() {

        }

        public void go() {
            System.out.println("This is inner class B. " + MemberInnTest.this.member);
        }
    }

    public B show() {
        return this.new B();
    }

    public static void main(String[] args) {

        B b = new MemberInnTest().show();
        b.go();
    }
}
