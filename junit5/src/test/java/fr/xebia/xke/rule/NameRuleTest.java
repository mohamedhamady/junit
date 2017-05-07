package fr.xebia.xke.rule;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

/**
 * The TestName Rule allows you to get current test name inside the test method.
 */
@EnableRuleMigrationSupport
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
