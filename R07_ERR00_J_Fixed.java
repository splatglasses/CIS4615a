/*
 * Rule 07. Exceptional Behavior (ERR)
 * Example: ERR00-J. Do not suppress or ignore checked exceptions
 * Compliant Solution
 */
import java.io.FileReader;
import java.io.IOException;

public class R07_ERR00_J_Fixed {

  public static void main(String[] args) {
    try {
      readConfigFile();
      System.out.println("Configuration loaded successfully.");
    } catch (IllegalStateException e) {
      System.err.println("Configuration could not be loaded: " + e.getMessage());
      System.exit(1);
    }
  }

  public static void readConfigFile() {
    try {
      FileReader fr = new FileReader("config.txt");
      fr.read();
      fr.close();
    } catch (IOException e) {
      throw new IllegalStateException("Unable to load required configuration file", e);
    }
  }
}