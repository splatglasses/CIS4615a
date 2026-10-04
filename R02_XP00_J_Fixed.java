/*
 * Rule 02. Expressions (EXP)
 * Example: XP00-J. Do not ignore values returned by methods
 * Compliant Solution
 */
import java.io.File;

public class R02_XP00_J_Fixed {

  public static void main(String[] args) {
    new R02_XP00_J_Fixed().deleteFile();
    System.out.println("File deleted.");
  }

  public void deleteFile() {
    File someFile = new File("someFileName.txt");
    // Do something with someFile
    if (!someFile.delete()) {
      // Handle failure to delete the file
      System.err.println("Failed to delete " + someFile.getPath());
      System.exit(1);
    }
  }
}