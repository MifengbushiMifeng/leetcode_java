package designpattern.observer.nonobserver;

public class Magine {

    private String name;

    private double cost;

    private String content;

    private boolean isChange = false;

    public Magine(String name, double cost) {
        this.name = name;

        this.cost = cost;
    }

    public String getNews() {
        if (isChange) {
            return content;
        }
        return null;
    }

    public void setContent(String content) {
        isChange = this.content == null || !this.content.equals("content");
        this.content = content;
    }

}
