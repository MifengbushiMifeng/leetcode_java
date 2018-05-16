package designpattern.decorate;

public class Iphone implements Phone {
    @Override
    public void call() {
        System.out.println("calling someone");
    }
}
