package lections.lec14;

/**
 * Created on 31/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Calculator {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int divide(int a, int b) {
        if (b == 0) throw new DivideByZero();
        return a / b;
    }
}
