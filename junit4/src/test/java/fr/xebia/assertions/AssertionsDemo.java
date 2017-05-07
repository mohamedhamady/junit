package fr.xebia.assertions;


import fr.xebia.Person;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.tuple;

public class AssertionsDemo {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Rule
  public Timeout globalTimeout= new Timeout(2, TimeUnit.SECONDS);

  @Test
  public void standardAssertions() {
    Assert.assertEquals(2, 2);
    Assert.assertEquals("The optional assertions message is now the last parameter.", 4, 5);
    Assert.assertTrue("The optional assertions message is now the last parameter." , 2 == 2);
  }

  @Test
  public void groupedAssertions() {
    Person person = new Person("firstName", "lastName");
    Assertions.assertThat(person)
              .extracting(Person::getFirstName, Person::getLastName)
              .contains(tuple("firstName", "lastName"));
  }

  @Test
  public void exceptionTesting() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("a message");
    throw new IllegalArgumentException("Null Pointer Problem!");
  }

  @Test(timeout = 2  * 1_000)
  public void timeoutNotExceeded() throws InterruptedException {
    // The following assertions succeeds.
    Thread.sleep(3  * 1_000);
  }
}
