package practices.genericity;

import java.util.Collection;

public class CollectionGenTest<T extends Collection> {

    private T coll;

    public CollectionGenTest(T coll) {
        this.coll = coll;
    }

    public T getColl() {
        return coll;
    }

    public void setColl(T coll) {
        this.coll = coll;
    }
}
