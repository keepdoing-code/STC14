package tasks.task05_reflection;


import java.math.BigDecimal;

/**
 * Created on 24.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Tests {
    public static void main(String[] args) throws Exception {
        System.out.println(new ObjectSaver(new BigDecimal(678)).toJSON());
        new ObjectSaver(new Person("Yuri", "+7911-577-77-77", 5000f, true)).toFile("person.json.txt");
    }
}
