package designpattern.decorate;

public class MPhone extends PhoneDecorate {

    public MPhone(Phone phone) {
        super(phone);
    }

    public void music() {
        System.out.println("singing a song");
    }

    @Override
    public void call() {
        music();
        super.call();
    }
}
