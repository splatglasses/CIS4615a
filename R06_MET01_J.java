/*
 * Rule 06. Methods (MET)
 * Example: MET01-J. Never use assertions to validate method arguments
 * Non-compliant Code Example
 */
public class R06_MET01_J {

  public static void main(String[] args) {
    // With assertions disabled (the default), Integer.MIN_VALUE is not
    // rejected and an incorrect result is computed and returned.
    int result = getAbsAdd(Integer.MIN_VALUE, 1);
    System.out.println("getAbsAdd(Integer.MIN_VALUE, 1) = " + result);
  }

  public static int getAbsAdd(int x, int y) {
    assert x != Integer.MIN_VALUE;
    assert y != Integer.MIN_VALUE;
    int absX = Math.abs(x);
    int absY = Math.abs(y);
    assert (absX <= Integer.MAX_VALUE - absY);
    return absX + absY;
  }
}