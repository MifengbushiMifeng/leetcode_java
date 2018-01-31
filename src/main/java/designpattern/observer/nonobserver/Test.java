package designpattern.observer.nonobserver;

public class Test {

    public static void main(String[] args) {

        Magine fashonMagine = new Magine("fashon", 20);
        People zhangsan = new People("zhangsan");
        zhangsan.subscribeMagine(fashonMagine);
        fashonMagine.setContent("The news!");

        System.out.println(zhangsan.getNews());
    }
}
