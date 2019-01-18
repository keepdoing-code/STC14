package tasks.task02_generic;

import java.util.Set;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Integer arrInt[] = {8, 23, 4, 0};
        Double arrDbl[] = {1.0, 6.3, 3.4, 0.0};
        MathBox<Double> mb = new MathBox<>(arrDbl);

        Set list = mb.splitter();
        for (Object o : list) {
            System.out.println(o.getClass().getSimpleName());
        }


        System.out.println("source: " + mb);
        try {
            mb.addObject(3.5);
        } catch (NotNumberException e) {
            e.printStackTrace();
        }
        System.out.println("divided: " + mb.splitter());
        System.out.println("sum: " + mb.summator());

    }

}
