package org.byteworks.calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double sin(double a) {
        return Math.sin(a);
    }

    public boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        if (n == 2_147_483_647) {
            return true;
        }
        for (int i = 3; (i * i) < n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
