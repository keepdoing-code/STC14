package tasks.task05_reflection;

/**
 * Created on 27/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Main {
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
}
