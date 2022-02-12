package com.tutorial.parameterizedtests;

import java.util.stream.Stream;

public class Strings {
    public static boolean isBlank(String s) {
        return s == null || s.trim().length() == 0;
    }


    static Stream<String> blankStrings() {
        return Stream.of(null, "", "  ");
    }
}
