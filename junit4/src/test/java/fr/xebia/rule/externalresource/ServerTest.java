package fr.xebia.rule.externalresource;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({A.class, B.class})
public class ServerTest {

  @ClassRule
  public static MyServer server = new MyServer();

}
