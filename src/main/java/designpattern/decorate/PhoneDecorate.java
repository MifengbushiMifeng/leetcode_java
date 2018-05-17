package designpattern.decorate;

public class PhoneDecorate implements Phone {

    Integer i = Integer.valueOf(1);

    private Phone phone;

    public PhoneDecorate(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();
    }
}
