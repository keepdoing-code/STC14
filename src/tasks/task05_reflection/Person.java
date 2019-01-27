package tasks.task05_reflection;

/**
 * Created on 25.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Person {
    private final String hide = "hide";
    public String name;
    public String phone;
    public float salary;
    public boolean man;

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Person setSalary(float salary) {
        this.salary = salary;
        return this;
    }

    public Person setMan(boolean man) {
        this.man = man;
        return this;
    }
}
