package fr.xebia.xke.dependencyInjection;

import fr.xebia.Person;
import fr.xebia.xke.extension.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MyMockitoTest {

  @BeforeEach
  void init(@Mock Person person) {
    when(person.getFirstName()).thenReturn("Dilbert");
  }

  @Test
  void simpleTestWithInjectedMock(@Mock Person person) {
    assertEquals("Dilbert", person.getFirstName());
  }

}