/*
 * Rule 00. Input Validation and Data Sanitization (IDS)
 * Example: IDS03-J. Do not log unsanitized user input
 * Compliant Solution
 */
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class R00_IDS03_J_Fixed {

  private static final Logger logger = Logger.getLogger("R00_IDS03_J_Fixed");

  public static void main(String[] args) {
    new R00_IDS03_J_Fixed().logLogin(false, "alice\r\n[INFO] attacker login succeeded");
  }

  public void logLogin(boolean loginSuccessful, String username) {
    if (loginSuccessful) {
      logger.severe("User login succeeded for: " + sanitizeUser(username));
    } else {
      logger.severe("User login failed for: " + sanitizeUser(username));
    }
  }

  public String sanitizeUser(String username) {
    return Pattern.matches("[A-Za-z0-9]+", username)
        ? username : "unauthorized user";
  }
}