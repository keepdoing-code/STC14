package ru.inno.lec02;

/**
 * Created by yuri on 15.01.19.
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        A a = new A(new C());
        a.doSome();
    }
}

class A{
    B b;

    public A(B b) {
        this.b = b;
    }

    String doSome(){
        return b.doSomeElse().toLowerCase();
    }
}

class B{
    String doSomeElse(){
        return "B do some else";
    }
}

class C extends B{
    @Override
    String doSomeElse() {
        return null;
//        return "C do some else";
    }
}