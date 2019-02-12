package lections.lec14;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 31/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(7, Calculator.sum(3, 4));
        assertEquals(-1, Calculator.sum(3, -4));

    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(2, Calculator.divide(4, 2));
        assertEquals(1, Calculator.divide(3, 2));
    }
}