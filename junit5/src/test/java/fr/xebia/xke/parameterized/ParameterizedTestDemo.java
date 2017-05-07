package fr.xebia.xke.parameterized;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class ParameterizedTestDemo {

  private static final Logger LOG = LoggerFactory.getLogger(ParameterizedTestDemo.class);

  static Stream<String> stringProvider() {
    return Stream.of("foo", "bar");
  }

  static Stream<Arguments> stringAndIntProvider() {
    return Stream.of(ObjectArrayArguments.create("foo", 1), ObjectArrayArguments.create("bar", 2));
  }

  @ParameterizedTest
  @ValueSource(strings = {"Hello", "World"})
  void testWithStringParameter(String argument) {
    LOG.info("Running testWithStringParameter. argument = {}", argument);
    assertNotNull(argument);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void testWithValueSource(int argument) {
    assertNotNull(argument);
  }

  @ParameterizedTest
  @EnumSource(TimeUnit.class)
  void testWithEnumSource(TimeUnit timeUnit) {
    LOG.info("Running testWithEnumSource, timeUnit = {}", timeUnit);
    assertNotNull(timeUnit.name());
  }

  @ParameterizedTest
  @MethodSource(names = "stringProvider")
  void testWithSimpleMethodSource(String argument) {
    assertNotNull(argument);
  }

  @ParameterizedTest
  @MethodSource(names = "stringAndIntProvider")
  void testWithMultiArgMethodSource(String first, int second) {
    assertNotNull(first);
    assertNotEquals(0, second);
  }

  @ParameterizedTest
  @CsvSource({"foo, 1", "bar, 2", "'baz, qux', 3"})
  void testWithCsvSource(String first, int second) {
    assertNotNull(first);
    assertNotEquals(0, second);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/two-column.csv")
  void testWithCsvFileSource(String first, int second) {
    assertNotNull(first);
    assertNotEquals(0, second);
  }

  @ParameterizedTest
  @MethodSource(names = "data")
  void testFabonacci(int input, int expected) {
    assertEquals(expected, Fibonacci.compute(input));
  }

  static Stream<Object[]> data() {
    return Stream.of(new Object[][] {{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}});
  }

  public static class Fibonacci {

    public static int compute(int n) {

      int result = 0;

      if (n <= 1) {
        result = n;
      } else {
        result = compute(n - 1) + compute(n - 2);
      }

      return result;
    }
  }
}
