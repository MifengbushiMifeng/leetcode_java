package designpattern.observer.observer;

public class Client {
    public static void main(String[] args) {

        SubjectMagine fashonMagine = new SubjectMagine("fashon", 20);
        ObserverPeople zhangsan = new ObserverPeople("zhangsan");
        ObserverPeople lisi = new ObserverPeople("lisi");

        fashonMagine.registerObserver(zhangsan);
        fashonMagine.registerObserver(lisi);

        fashonMagine.setContent("news news news!!!");
    }
}
