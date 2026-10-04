/*
 * Rule 01. Declarations and Initialization (DCL)
 * Example: DCL00-J. Prevent class initialization cycles
 * Compliant Solution
 */
public class R01_DCL00_J_Fixed {

  private final int balance;
  private static final int deposit = (int) (Math.random() * 100); // Random deposit
  private static final R01_DCL00_J_Fixed c = new R01_DCL00_J_Fixed();

  public R01_DCL00_J_Fixed() {
    balance = deposit - 10; // Subtract processing fee
  }

  public static void main(String[] args) {
    System.out.println("The account balance is: " + c.balance);
  }
}