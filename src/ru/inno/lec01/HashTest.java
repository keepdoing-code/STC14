package ru.inno.lec01;

/**
 * Created by yuri on 14.01.19.
 */
public class HashTest {

    public static void main(String[] args) {
        Test a = new Test(1,2);
        Test b = new Test(1,2);

        String c = "";
        String d = "werty";
        Integer i = 1;
        i.equals(i);
        c.equals(d);


        c.equals(d);


        System.out.println(Integer.toHexString(a.hashCode()) + "\n\n");


        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a);
        System.out.println(b.toString());

        float f = 0f;
        System.out.println(f);
    }

}

class Test{
    private final int a;
    private final int b;
    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
