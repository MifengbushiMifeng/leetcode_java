package designpattern.observer.nonobserver;

public class People {

    private String name;

    private Magine magine;

    public People(String name) {
        this.name = name;

    }

    public void subscribeMagine(Magine magine) {
        this.magine = magine;
    }

    public String getNews() {

        return magine.getNews();
    }
}
