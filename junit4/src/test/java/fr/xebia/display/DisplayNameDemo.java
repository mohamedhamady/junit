package fr.xebia.display;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class DisplayNameDemo {

  @Rule
  public TestName name= new TestName();

  @Test
  public void test1() {
    Assert.assertEquals("test1", name.getMethodName());
  }

  @Test
  public void test2() {
    Assert.assertEquals("test2", name.getMethodName());
  }

}
