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

    public static void main(String[] args) throws Exception {
        String fileName = "person.json.txt";

        Person person = new Person()
                .setMan(true)
                .setPhone("+79110001122")
                .setSalary(6000f)
                .setName("John");

        JSONConv json = new JSONConv();
        json.toFile(fileName, person);
        System.out.println("before: \r\n" + json.toString(person));

        Person a = (Person) json.fromFile(fileName);
        System.out.println("after: \r\n" + json.toString(a));
    }

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
