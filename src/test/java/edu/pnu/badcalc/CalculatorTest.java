package edu.pnu.badcalc;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    // ------- Tests for add() -------

    @Test
    public void testAddTwoPositiveNumbers() {
        Calculator c = new Calculator();
        double result = c.add(2.5, 3.5);
        assertEquals(6.0, result, 0.0001);
    }

    @Test
    public void testAddWithNegativeNumber() {
        Calculator c = new Calculator();
        double result = c.add(-5, 2);
        assertEquals(-3.0, result, 0.0001);
    }

    @Test
    public void testAddWithZero() {
        Calculator c = new Calculator();
        double result = c.add(0, 10);
        assertEquals(10.0, result, 0.0001);
    }

    // ------- Tests for subtract() -------

    @Test
    public void testSubtractPositiveNumbers() {
        Calculator c = new Calculator();
        double result = c.subtract(10, 4);
        assertEquals(6.0, result, 0.0001);
    }

    @Test
    public void testSubtractResultNegative() {
        Calculator c = new Calculator();
        double result = c.subtract(3, 7);
        assertEquals(-4.0, result, 0.0001);
    }

    @Test
    public void testSubtractWithZero() {
        Calculator c = new Calculator();
        double result = c.subtract(5, 0);
        assertEquals(5.0, result, 0.0001);
    }

    // ------- Tests for parseAndCompute() -------

    @Test
    public void testParseAndComputeSimpleAddition() {
        Calculator c = new Calculator();
        double result = c.parseAndCompute("1+1");
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testParseAndComputeWithSpaces() {
        Calculator c = new Calculator();
        double result = c.parseAndCompute("  10  +  5 ");
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testParseAndComputeDecimals() {
        Calculator c = new Calculator();
        double result = c.parseAndCompute("2.5+3.5");
        assertEquals(6.0, result, 0.0001);
    }

    @Test(expected = RuntimeException.class)
    public void testParseAndComputeInvalidExpressionThrows() {
        Calculator c = new Calculator();
        c.parseAndCompute("1+2+3");   // تعبير غير مدعوم
    }

    @Test(expected = RuntimeException.class)
    public void testParseAndComputeLettersThrows() {
        Calculator c = new Calculator();
        c.parseAndCompute("abc");
    }
}
