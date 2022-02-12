package com.tutorial.parameterizedtests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNumbers {

    @ParameterizedTest
    @ValueSource(ints = {1, 21, 3, 45, 5})
    void isOdd_ShouldReturnTrueForAnOddNumber(int number) {
        assertTrue(Numbers.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 22, 4, 44, 6})
    void isEven_ShouldReturnTrueForAnEvenNumber(int number) {
        assertTrue(Numbers.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 7, 13, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97})
    void isPrime_ShouldReturnTrueForAPrimeNumber(int number) {
        assertTrue(Numbers.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 8, 13, 21})
    void isFibonacci_ShouldReturnTrueForAFibonacciNumber(int number) {
        assertTrue(Numbers.isFibonacci(number));
    }
}

