package designpattern.decorate;


public class Run {

    public static void main(String[] args){

        Phone phone = new Iphone();
        phone = new MPhone(phone);
        phone = new TPhone(phone);

        phone.call();
    }
}
