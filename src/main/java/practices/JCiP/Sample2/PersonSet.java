package practices.JCiP.Sample2;

import java.util.HashSet;
import java.util.Set;

public class PersonSet {

    private final Set<Person> set = new HashSet<>();

    public synchronized void addPerson(Person p) {
        set.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return set.contains(p);
    }

    class Person {

    }
}
