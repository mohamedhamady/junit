package fr.xebia.nested;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.EmptyStackException;
import java.util.Stack;

@RunWith(Enclosed.class)
public class TestingAStackDemo {

  private static Stack<Object> stack;

  // Ignored
  @Test
  public void isInstantiatedWithNew() {
    new Stack<>();
  }

  public static class WhenNew {

    @Before
    public void createNewStack() {
      System.out.print("Bofore");
      stack = new Stack<>();
    }

    @Test
    public void isEmpty() {
      Assert.assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void throwsExceptionWhenPopped() {
      stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void throwsExceptionWhenPeeked() {
      stack.peek();
    }
  }

  public static class AfterPushing {

    String anElement = "an element";

    @Before
    public void pushAnElement() {
      stack = new Stack<>();
      stack.push(anElement);
    }

    @Test
    public void isNotEmpty() {
      Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void returnElementWhenPopped() {
      Assert.assertEquals(anElement, stack.pop());
      Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void returnElementWhenPeeked() {
      Assert.assertEquals(anElement, stack.peek());
      Assert.assertFalse(stack.isEmpty());
    }
  }

}
