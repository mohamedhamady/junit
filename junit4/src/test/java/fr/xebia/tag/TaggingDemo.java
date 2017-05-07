package fr.xebia.tag;

import fr.xebia.Fast;
import fr.xebia.Slow;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Fast.class)
public class TaggingDemo {

  @Test
  @Category(Slow.class)
  public void slowTest() {
  }

  @Test
  public void fastTest() {
  }

}
