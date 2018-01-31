package designpattern.observer.observer;


public class ObserverPeople implements Observer {

    private String name;

    public ObserverPeople(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        readMagine(news);
    }

    public void readMagine(String content) {
        System.out.println("The content that the observer get: " + content);
    }
}
