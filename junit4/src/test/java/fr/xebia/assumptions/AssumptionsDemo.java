package fr.xebia.assumptions;

import org.hamcrest.core.Is;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

public class AssumptionsDemo {

  @BeforeClass
  public static void setup() {
    System.setProperty("ENV", "DEV");
  }

  @Test
  public void testOnlyOnCiServer() {
    Assume.assumeTrue("CI".equals(System.getProperty("ENV")));
    // remainder of test
  }

  @Test
  public void testOnlyOnDeveloperWorkstation() {
    Assume.assumeTrue("Aborting test: not on developer workstation", "DEV".equals(System.getProperty("ENV")));
    // remainder of test
  }

  @Test
  public void testInAllEnvironments() {
    Assume.assumeThat(1, Is.is(1));
    // remainder of test
  }

}
