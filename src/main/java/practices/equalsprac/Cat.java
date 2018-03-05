package practices.equalsprac;

public class Cat {

    private int height;

    private int weight;

    public Cat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Cat)) {
            return false;
        }

        Cat c = (Cat) obj;
        return c.height == this.height && c.weight == this.weight;

    }
}
