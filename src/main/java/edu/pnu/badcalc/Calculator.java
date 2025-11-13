package edu.pnu.badcalc;

import java.util.*;

public class Calculator {
    public double last;

    public double add(double a, double b) {
        last = a + b;
        return last;
    }

    public double subtract(double a, double b) {
        last = a - b;
        return last;
    }

    public double multiply(double a, double b) {
        last = a * b;
        return last;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        last = a / b;
        return last;
    }

    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    private int findOperatorIndex(String expr) {
        for (int i = 1; i < expr.length() - 1; i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                return i;
            }
        }
        return -1;
    }


    public double parseAndCompute(String expr) {
        if (expr == null) {
            throw new IllegalArgumentException("Expression cannot be null");
        }

        String trimmed = expr.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty");
        }

        String[] t = trimmed.split("\\s+");
        double a;
        double b;
        String op;

        if (t.length == 3) {
            // صيغة مثل: 1 + 1
            a = Double.parseDouble(t[0]);
            op = t[1];
            b = Double.parseDouble(t[2]);
        } else if (t.length == 1) {
            // صيغة مثل: 1+1 بدون مسافات
            int opIndex = findOperatorIndex(trimmed);
            if (opIndex <= 0 || opIndex >= trimmed.length() - 1) {
                throw new IllegalArgumentException("Invalid expression format");
            }
            a = Double.parseDouble(trimmed.substring(0, opIndex));
            op = String.valueOf(trimmed.charAt(opIndex));
            b = Double.parseDouble(trimmed.substring(opIndex + 1));
        } else {
            throw new IllegalArgumentException("Invalid expression format");
        }

        switch (op) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + op);
        }
    }

}