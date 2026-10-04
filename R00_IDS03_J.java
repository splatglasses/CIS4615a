/*
 * Rule 00. Input Validation and Data Sanitization (IDS)
 * Example: IDS03-J. Do not log unsanitized user input
 * Non-compliant Code Example
 */
import java.util.logging.Logger;

public class R00_IDS03_J {

  private static final Logger logger = Logger.getLogger("R00_IDS03_J");

  public static void main(String[] args) {
    new R00_IDS03_J().logLogin(false, "alice\r\n[INFO] attacker login succeeded");
  }

  public void logLogin(boolean loginSuccessful, String username) {
    if (loginSuccessful) {
      logger.severe("User login succeeded for: " + username);
    } else {
      logger.severe("User login failed for: " + username);
    }
  }
}