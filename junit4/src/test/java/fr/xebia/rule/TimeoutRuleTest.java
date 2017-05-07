package fr.xebia.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

/**
 * The Timeout Rule applies the same timeout to all test methods in a class.
 *
 * @author mohamed.hamady
 */
public class TimeoutRuleTest {

  @Rule
  public Timeout timeout = new Timeout(2, TimeUnit.MILLISECONDS);

  @Test
  public void testA() throws Exception {
    // Open a website...
    Thread.sleep(3);
  }

  @Test
  public void testB() throws Exception {
    // Login a website etc.
  }
}
