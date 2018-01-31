package designpattern.observer.observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectMagine implements Subject {

    List<Observer> observerList = new ArrayList<>();

    private String name;

    private double cost;

    private String content;

    private boolean isChanged = false;

    public SubjectMagine(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public void registerObserver(Observer ob) {
        if (!observerList.contains(ob)) {
            observerList.add(ob);
        }
    }

    @Override
    public void removeObserver(Observer ob) {
        if (observerList.contains(ob)) {
            observerList.remove(ob);
        }
    }

    @Override
    public void notifyObservers() {

        if (isChanged) {
            for (Observer ob : observerList) {
                ob.update(content);
            }
        }

        isChanged = false;
    }

    public void setContent(String content) {
        if (this.content == null || !this.content.equals("content")) {
            isChanged = true;
        }
        this.content = content;
        notifyObservers();
    }
}
