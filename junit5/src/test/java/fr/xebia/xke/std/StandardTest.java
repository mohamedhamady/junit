package fr.xebia.xke.std;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

class StandardTest {

  // @BeforeAll
  static void initAll() {
    System.out.print("before all -> ");
  }

  // @AfterAll
  static void tearDownAll() {
    System.out.print("after all");
  }

  @BeforeEach
  void init() {
    System.out.print("before each ->");
  }

  @Test
  void succeedingTest() {
  }

  @Test
  void failingTest() {
    fail("a failing test");
  }

  @Test
  @Disabled("for demonstration purposes")
  void skippedTest() {
    // not executed
  }

  @AfterEach
  void tearDown() {
    System.out.print("after each ->");
  }

}
