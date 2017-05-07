package fr.xebia.rule.externalresource;

import org.junit.rules.ExternalResource;

public class MyServer extends ExternalResource {

  @Override
  protected void before() throws Throwable {
    System.out.println("start the server");
  }

  @Override
  protected void after() {
    System.out.println("stop the server");
  }
}
