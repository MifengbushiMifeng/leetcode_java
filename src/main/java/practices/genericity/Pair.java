package practices.genericity;

public class Pair<T> {

    private T first;

    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Manager mgr1 = new Manager("Jack", 10000.99);
        Manager mgr2 = new Manager("Tom", 10001.01);
        Pair<Manager> managerPair = new Pair<Manager>(mgr1, mgr2);
//        Pair<? extends Employee> employeePair = managerPair;
//        employeePair.setFirst(new Employee("Tony", 100));

        printEmployeeInfo(managerPair);
    }


    private static void printEmployeeInfo(Pair<? extends Employee> pair) {
        System.out.println(pair.getFirst().getName() + " : " + pair.getSecond().getName());
    }

}

class Employee {

    private String name;

    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee {

    public Manager(String name, double salary) {
        super(name, salary);
    }
}

class President extends Manager {

    public President(String name, double salary) {
        super(name, salary);
    }
}

class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
//        p.setFirst(new Object());
        return p.getFirst() == null || p.getSecond() == null;
    }
}