package lections.lec14;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created on 31/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
class CalculatorTestJUnit5 {

    private static Calculator calc;

    @Before
    static void setup() {
        calc = new Calculator();
    }

    @Test
    void testSum() {
        int result = Calculator.sum(4, 6);
        Assertions.assertEquals(10, result);
    }

    @Test
    void testDivide() {
        int result = Calculator.divide(8, 2);
        Assertions.assertEquals(4, result);
        Assertions.assertThrows(DivideByZero.class, () -> Calculator.divide(1, 0), "Zero division");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme