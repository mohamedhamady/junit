package fr.xebia.rule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


/**
 * TestWatcher are classes for Rules and they watch test methods and write log for the each passing
 * and failing tests. You can keep an eye on the tests with TestWatcher Rule.
 */
public class TestWatcherRuleTest {

  private static String watchedLog;

  @Rule
  public TestWatcher watcher = new TestWatcher() {

    @Override
    protected void failed(Throwable e, Description description) {
      watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
      System.out.print("Failed! Watchlog:\\n" + watchedLog);
    }

    @Override
    protected void succeeded(Description description) {
      watchedLog += description.getDisplayName() + " " + "success!\n";
      System.out.print("Succeed! Watchlog:\\n" + watchedLog);
    }

    @Override
    protected void finished(Description description) {
      super.finished(description);
      System.out.println(
          "Test finished! Watchlog:\n" + watchedLog + "\n------------------------------------\n");
    }
  };

  @Test
  public void fails() {
    Assert.fail();
  }

  @Test
  public void succeeds() {
  }
}
