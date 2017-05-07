package fr.xebia.standard;

import org.junit.*;

public class FirstJUnit4Tests {

  @BeforeClass
  public static void initAll() {
    System.out.print("before all -> ");
  }

  @AfterClass
  public static void tearDownAll() {
    System.out.print("after all");
  }

  @Before
  public void init() {
    System.out.print("before each ->");
  }

  @Test
  public void succeedingTest() {
  }

  @Test
  public void failingTest() {
    Assert.fail("a failing test");
  }

  @Test
  @Ignore("for demonstration purposes")
  public void skippedTest() {
    // not executed
  }

  @After
  public void tearDown() {
    System.out.print("after each ->");
  }

}
