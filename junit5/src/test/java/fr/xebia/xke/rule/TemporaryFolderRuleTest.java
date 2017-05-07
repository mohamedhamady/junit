package fr.xebia.xke.rule;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * The TemporaryFolder Rule allows you to create files and folders. This files
 * are folders are deleted whether the test passes or fails when the test method
 * finishes. By default no exception is thrown if resources cannot be deleted.
 * So, if you need to run a test that needs a temporary file or folder then you
 * can use this rule as shown below.
 */
@EnableRuleMigrationSupport
public class TemporaryFolderRuleTest {

  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();

  @Test
  public void testFile() throws Exception {
    File testFolder = tempFolder.newFolder("TestFolder");
    File testFile = tempFolder.newFile("test.txt");
    assertTrue(testFolder.exists());
    assertTrue(testFile.exists());
  }

}
