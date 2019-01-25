package tasks.task05_reflection;

/**
 * Created on 25.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Person {
    public final String name;
    public String phone;
    public float salary;
    public boolean man;


    public Person(String name, String phone, float salary, boolean man) {
        this.name = name;
        this.phone = phone;
        this.salary = salary;
        this.man = man;
    }

    public void printName() {
        System.out.println(name);
    }
}
