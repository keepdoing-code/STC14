package lections.lec04;

/**
 * Created by yuri on 17.01.19.
 */
public class SerializeDemo {
    public static void main(String[] args) {
        Person person = new Person("Yuri", 30, 178);
    }

}

class Person {
    public final String name;
    public final int age;
    public final int length;

    public Person(String name, int age, int length) {
        this.name = name;
        this.age = age;
        this.length = length;
    }

}
