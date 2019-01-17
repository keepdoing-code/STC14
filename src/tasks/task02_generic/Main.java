package tasks.task02_generic;

/**
 * Created by yuri on 17.01.19.
 */
public class Main {
    public static void main(String[] args) {
        Integer arr[] = {8, 23, 4, 0};

        MathBox mb = new MathBox(arr);
        System.out.println(mb);

        MathBox mb1 = new MathBox(new Integer[]{8, 23, 4, 0});
        System.out.println(mb1);

        System.out.println(mb.equals(mb1));
    }
}
