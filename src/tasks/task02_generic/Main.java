package tasks.task02_generic;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Integer arrInt[] = {8, 23, 4, 0};
        Double arrDbl[] = {1.0, 6.3, 3.4, 0.0};

        MathBox<Double> mb = new MathBox<>(arrDbl);
        System.out.println(mb);
        System.out.println(mb.splitter());
        mb.remove(3.4);
        System.out.println(mb);

        System.out.println(mb.summator());


    }
}
