package testfinal;

public class TestFinal {

    public static void main(String[] args) {

        Person person = new Person();

        person.setAge(13);
        person.setName("Tom");

        checkPerson(person);

        System.out.print(person.getName() + " / " + person.getAge());
    }

    private static void checkPerson(final Person aPerson) {
        // will get an compile error
        //aPerson = new Person();

        aPerson.setName("Mike");
    }

    static class Person {

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private String name;

        private int age;
    }
}
