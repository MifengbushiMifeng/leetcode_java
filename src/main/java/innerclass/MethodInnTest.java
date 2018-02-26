package innerclass;

public class MethodInnTest {

    class AMemberInn {

        public void memberGo() {
            System.out.println("This is a member in class");
        }

    }

    private String member = "This is global member";

    final int n = 4;

    public void driver() {

        final String member2 = "local member";

        class B extends AMemberInn {

            public void show() {
                System.out.println(MethodInnTest.this.member);
                System.out.println(member2);
            }

        }

        new B().memberGo();
        new B().show();
    }

    public static void main(String[] args){
        new MethodInnTest().driver();
    }

}
