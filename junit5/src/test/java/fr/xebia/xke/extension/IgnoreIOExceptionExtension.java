package fr.xebia.xke.extension;

import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestExtensionContext;

import java.io.IOException;

public class IgnoreIOExceptionExtension implements TestExecutionExceptionHandler {

  @Override
  public void handleTestExecutionException(TestExtensionContext context, Throwable throwable)
    throws Throwable {

    if (throwable instanceof IOException) {
      return;
    }
    throw throwable;
  }
}
