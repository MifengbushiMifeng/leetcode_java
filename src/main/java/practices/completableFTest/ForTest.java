package practices.completableFTest;

import java.util.ArrayList;
import java.util.List;

public class ForTest {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Xiaoming", "21"));
        persons.add(new Person("Zhangsan", "19"));
        persons.add(new Person("Lisi", "22"));
        persons.add(new Person("Tony", "30"));
        persons.add(new Person("Alex", "28"));

//        persons.forEach(person -> outPerson);
//        persons::get;
    }

    private static class Person {

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }

        String name;

        String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
