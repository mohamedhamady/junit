package fr.xebia.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Verifier rule does a verification check and if it is failed, test is finished
 * with failing result. You can write your custom verification logic with
 * Verifier Rule.
 */
public class VerifierRuleTest {

  private List<String> errorLog = new ArrayList<String>();

  @Rule
  public Verifier verifier = new Verifier() {
    // After each method perform this check
    @Override
    public void verify() {
      assertTrue("Error Log is not Empty!", errorLog.isEmpty());
    }
  };

  @Test
  public void testWritesErrorLog() {
    // ...
    errorLog.add("There is an error!");
  }
}
