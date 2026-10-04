/*
 * Rule 02. Expressions (EXP)
 * Example: XP00-J. Do not ignore values returned by methods
 * Non-compliant Code Example
 */
import java.io.File;

public class R02_XP00_J {

  public static void main(String[] args) {
    new R02_XP00_J().deleteFile();
    System.out.println("File deleted.");
  }

  public void deleteFile() {
    File someFile = new File("someFileName.txt");
    // Do something with someFile
    someFile.delete();
  }
}