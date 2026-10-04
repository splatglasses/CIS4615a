/*
 * Rule 06. Methods (MET)
 * Example: MET01-J. Never use assertions to validate method arguments
 * Compliant Solution
 */
public class R06_MET01_J_Fixed {

  public static void main(String[] args) {
    // The invalid argument is always rejected with an
    // IllegalArgumentException, even with assertions disabled.
    try {
      getAbsAdd(Integer.MIN_VALUE, 1);
    } catch (IllegalArgumentException e) {
      System.out.println("IllegalArgumentException thrown for Integer.MIN_VALUE");
    }
  }

  public static int getAbsAdd(int x, int y) {
    if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
      throw new IllegalArgumentException();
    }
    int absX = Math.abs(x);
    int absY = Math.abs(y);
    if (absX > Integer.MAX_VALUE - absY) {
      throw new IllegalArgumentException();
    }
    return absX + absY;
  }
}