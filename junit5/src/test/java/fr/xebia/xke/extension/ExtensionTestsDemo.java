package fr.xebia.xke.extension;

import fr.xebia.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(TimingExtension.class)
class ExtensionTestsDemo {

  @BeforeEach
  void init(@Mock Person person) {
    when(person.getFirstName()).thenReturn("Dilbert");
  }

  @Test
  void simpleTestWithInjectedMock(@Mock Person person) {
    assertEquals("Dilbert", person.getFirstName());
  }

  @Test
  @ExtendWith(IgnoreIOExceptionExtension.class)
  void ignoreIoException() throws IOException {
    throw new IOException(" test");
  }

}