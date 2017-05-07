package fr.xebia.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * The ExpectedException Rule allows to have more control on of expected
 * exception types and messages.
 */
public class ExpectedExceptionRuleTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void throwsNullPointerException() {
    thrown.expect(NullPointerException.class);
    throw new NullPointerException();
  }

  @Test
  public void throwsNullPointerExceptionWithMessage() {
    thrown.expect(NullPointerException.class);
    thrown.expectMessage("Null Pointer Problem!");
    throw new NullPointerException("Null Pointer Problem!");
  }
}
