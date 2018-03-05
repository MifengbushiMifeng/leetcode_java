package practices.equalsprac;


public class ColorCat extends Cat {

    private String color;

    public ColorCat(int height, int weight, String color) {
        super(height, weight);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Cat)) {
            return false;
        }

        if (!(obj instanceof ColorCat)) {
            return ((Cat) obj).equals(this);
        }

        return super.equals(obj) && ((ColorCat) obj).color.equals(this.color);
    }
}
