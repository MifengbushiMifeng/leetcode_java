package innerclass;

public class AnonymousInner {

    public static void main(String[] args) {

        new Object() {
            void show() {
                System.out.println("show run!");
            }
        }.show();

        Object obj = new Object() {
            void show() {
                System.out.println("show run!");

            }
        };
        //will get an compile error
        //obj.show();
    }
}
