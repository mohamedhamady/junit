package fr.xebia.xke.tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
class TaggingDemo {

  @Test
  @Tag("slow")
  void slowTest() {
  }

  @Test
  public void fastTest() {
  }
}
