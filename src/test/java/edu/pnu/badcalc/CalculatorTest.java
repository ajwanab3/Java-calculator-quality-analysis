package edu.pnu.badcalc;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        double result = c.add(1, 1);
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testSubtract() {
        Calculator c = new Calculator();
        double result = c.subtract(5, 2);
        assertEquals(3.0, result, 0.0001);
    }

    @Test
    public void testParseAndCompute() {
        Calculator c = new Calculator();
        double result = c.parseAndCompute("1+1");
        assertEquals(2.0, result, 0.0001);
    }
}
