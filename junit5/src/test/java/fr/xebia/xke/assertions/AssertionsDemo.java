package fr.xebia.xke.assertions;

import fr.xebia.Person;
import fr.xebia.xke.extension.TimingExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TimingExtension.class)
public class AssertionsDemo {

  @Test
  void standardAssertions() {
    assertEquals(2, 2);
    assertEquals(4, 4, "The optional assertions message is now the last parameter.");
    assertTrue(2 == 2,
               () -> "Assertion messages can be lazily evaluated -- to avoid constructing complex messages unnecessarily.");
  }

  @Test
  void groupedAssertions() {
    // In a grouped assertions all assertions are executed, and any
    // failures will be reported together.
    Person person = new Person("firstName", "lastName");
        assertAll("person",
                  () -> assertEquals("firstName", person.getFirstName()),
                  () -> assertEquals("lastName", person.getLastName())
        );
  }

  @Test
  void exceptionTesting() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      throw new IllegalArgumentException("a message");
    });
    assertEquals("a message", exception.getMessage());
  }

  @Test
  void timeoutNotExceeded() {
    // The following assertions succeeds.
    assertTimeout(ofSeconds(2), () -> {
      // Perform task that takes less than 2 minutes.
    });
  }

  @Test
  void timeoutNotExceededWithResult() {
    // The following assertions succeeds, and returns the supplied object.
    String actualResult = assertTimeout(ofSeconds(2), () -> "a result");
    assertEquals("a result", actualResult);
  }

  @Test
  void timeoutNotExceededWithMethod() {
    // The following assertions invokes a method reference and returns an object.
    String actualGreeting = assertTimeout(ofSeconds(2), AssertionsDemo::greeting);
    assertEquals("hello world!", actualGreeting);
  }

  @Test
  void timeoutExceeded() {
    // The following assertions fails with an error message similar to:
    // execution exceeded timeout of 10 ms by 91 ms
    assertTimeout(ofMillis(10), () -> {
      // Simulate task that takes more than 10 ms.
      Thread.sleep(100);
    });
  }

  @Test
  void timeoutExceededWithPreemptiveTermination() {
    // The following assertions fails with an error message similar to:
    // execution timed out after 10 ms
    assertTimeoutPreemptively(ofMillis(10), () -> {
      // Simulate task that takes more than 10 ms.
      Thread.sleep(100);
    });
  }

  private static String greeting() {
    return "hello world!";
  }
}
