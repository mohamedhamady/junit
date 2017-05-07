package fr.xebia.parameterized;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ParametrizedSingleParameter {

  @Parameter
  public String data;

  @Parameters
  public static Iterable<? extends Object> data() {
    return Arrays.asList("foo", "bar");
  }

  @Test
  public void test() {
    assertTrue(Arrays.asList("foo", "bar").contains(data));
  }

}