/*
 * Rule 07. Exceptional Behavior (ERR)
 * Example: ERR00-J. Do not suppress or ignore checked exceptions
 * Non-compliant Code Example
 */
import java.io.FileReader;
import java.io.IOException;

public class R07_ERR00_J {

  public static void main(String[] args) {
    readConfigFile();
    System.out.println("Configuration loaded successfully.");
  }

  public static void readConfigFile() {
    try {
      FileReader fr = new FileReader("config.txt");
      fr.read();
      fr.close();
    } catch (IOException e) {
      // Exception suppressed - the program continues as if nothing happened
    }
  }
}