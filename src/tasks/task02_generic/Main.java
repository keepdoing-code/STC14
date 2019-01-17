package tasks.task02_generic;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Integer arr[] = {8, 23, 4, 0};

        MathBox<Integer> mb = new MathBox<>(arr);
        System.out.println(mb);
        System.out.println(mb.splitter());
        mb.remove(23);
        System.out.println(mb);

        System.out.println(mb.summator());


    }
}
