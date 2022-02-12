package com.tutorial.parameterizedtests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStrings {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"\t", "\n", "    "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String str) {
        assertTrue(Strings.isBlank(str));

    }

    @ParameterizedTest
    @CsvSource({"test, TEST", "tEst, TEST", "Java, JAVA"})
    void isUpperCase_ShouldReturnTrueForUpperCaseStrings(String str, String expected) {
        String actualValue = str.toUpperCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/words.csv", "/names.csv"}, numLinesToSkip = 1)
    void isUpperCase_ShouldReturnTrueForUpperCaseStringsFromFile(String str, String expected) {
        String actualValue = str.toUpperCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void isUpperCase_ShouldReturnTrueForUpperCaseStringsFromMethodSource(String str, String expected) {
        String actualValue = str.toUpperCase();
        assertEquals(expected, actualValue);
    }

    static Stream<Arguments> stringProvider() {
        return Stream.of(
                Arguments.of("test", "TEST"),
                Arguments.of("tEst", "TEST"),
                Arguments.of("Java", "JAVA")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, Strings.isBlank(input));
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

    @ParameterizedTest
    @MethodSource // hmm, no method name ... Not an issue because a method that provides the values is created with the exact same name just right below this
    void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input) {
        assertTrue(Strings.isBlank(input));
    }

    private static List<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument() {
        return List.of("\n", "", "  ");
    }

    @ParameterizedTest
    @MethodSource("com.tutorial.parameterizedtests.Strings#blankStrings")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsFromExternalSource(String input) {
        assertTrue(Strings.isBlank(input));
    }

    @ParameterizedTest
    @ArgumentsSource(BlankStringsArgumentsProvider.class)
    void isBlank_ShouldReturnTrueForNullOrBlankStringsFromArgumentProvider(String input) {
        assertTrue(Strings.isBlank(input));
    }

    static Stream<Arguments> arguments = Stream.of(
            Arguments.of(null, true), // null strings should be considered blank
            Arguments.of("", true),
            Arguments.of("  ", true),
            Arguments.of("not blank", false)
    );

    @ParameterizedTest
    @VariableSource("arguments")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsVariableSource(
            String input, boolean expected) {
        assertEquals(expected, Strings.isBlank(input));
    }
}
