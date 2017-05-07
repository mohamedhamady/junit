package fr.xebia.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.*;

/**
 * The ErrorCollector Rule allows execution of a test to continue after the
 * first problem is found. It collects all the errors and reports them all at
 * once.
 */
public class ErrorCollectorRuleTest {

  @Rule
  public ErrorCollector collector = new ErrorCollector();

  @Test
  public void example() {
    collector.addError(new Throwable("First Erdror!"));
    collector.addError(new Throwable("Second Error!"));

    collector.checkThat(5, is(8)); // First Error
    collector.checkThat(5, is(not(8))); // Passed
    collector.checkThat(5, is(equalTo(9))); // Second Error
  }
}