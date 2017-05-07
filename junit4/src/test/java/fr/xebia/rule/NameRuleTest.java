package fr.xebia.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

/**
 * The TestName Rule allows you to get current test name inside the test method.
 */
public class NameRuleTest {

  @Rule
  public TestName name = new TestName();

  @Test
  public void testOne() {
    assertEquals("testOne", name.getMethodName());
  }

  @Test
  public void testTwo() {
    assertEquals("testTwo", name.getMethodName());
  }
}
