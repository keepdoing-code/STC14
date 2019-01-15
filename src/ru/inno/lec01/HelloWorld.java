package ru.inno.lec01;

/**
 * Created by yuri on 14.01.19.
 */
public class HelloWorld {
    static Integer x;

    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}


class Logger{
    Logger(String obj){
        System.out.println("init "+ obj);
    }
}

class Animal{
    static Logger staticLogger = new Logger("static name");

    private String name;
    private String age;
    static String staticName = "";

    static {
        System.out.println("Static Animal");
    }

    public Animal() {
        System.out.println("Animal Instance Constructor");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (!name.equals(animal.name)) return false;
        return age.equals(animal.age);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }
}

class Dog extends Animal {
    static String dogName = "";
    String instanceName = "";

    static{
        System.out.println("Static Dog");
    }

    public Dog() {
        super();
        System.out.println("Dog Instance constructor");
    }
}