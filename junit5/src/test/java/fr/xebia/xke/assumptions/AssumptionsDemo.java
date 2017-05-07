package fr.xebia.xke.assumptions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsDemo {

  @BeforeAll
  public static void setup() {
    System.setProperty("ENV", "DEV");
  }

  @Test
  void testOnlyOnCiServer() {
    assumeTrue("CI".equals(System.getProperty("ENV")));
    // remainder of test
  }

  @Test
  void testOnlyOnDeveloperWorkstation() {
    assumeTrue("DEV".equals(System.getProperty("ENV")), () -> "Aborting test: not on developer workstation");
    // remainder of test
  }

  @Test
  void testInAllEnvironments() {
    assumingThat("CI".equals(System.getenv("ENV")), () -> {
      // perform these assertions only on the CI server
      assertEquals(2, 3);
    });

    // perform these assertions in all environments
    assertEquals("a string", "a string");
  }

}
