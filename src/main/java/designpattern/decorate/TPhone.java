package designpattern.decorate;

public class TPhone extends PhoneDecorate {

    public TPhone(Phone phone) {
        super(phone);
    }

    public void currentTime() {
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void call() {
        super.call();
        currentTime();
    }

}
