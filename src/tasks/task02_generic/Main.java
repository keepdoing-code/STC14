package tasks.task02_generic;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Double arr[] = {8.0, 23.0, 4.0, 0.0};

        MathBox<Double> mb = new MathBox(arr);
        System.out.println(mb);

        MathBox<Double> mb1 = new MathBox(new Double[]{8.0, 23.0, 4.0, 0.0, 1.0});
        System.out.println(mb1);

        System.out.println(mb.equals(mb1));
    }
}
