package com.tutorial.parameterizedtests;

public class Numbers {
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFibonacci(int number) {
        int a = 0;
        int b = 1;
        int c = a + b;
        while (c < number) {
            a = b;
            b = c;
            c = a + b;
        }
        return c == number;
    }
}
