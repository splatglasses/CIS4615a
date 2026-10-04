/*
 * Rule 09. Locking (LCK)
 * Example: LCK07-J. Avoid deadlock by requesting and releasing locks in the same order
 * Compliant Solution
 */
public class R09_LCK07_J_Fixed {

  private final Object lock1 = new Object();
  private final Object lock2 = new Object();

  public static void main(String[] args) throws InterruptedException {
    R09_LCK07_J_Fixed d = new R09_LCK07_J_Fixed();

    Thread t1 = new Thread(d::method1);
    Thread t2 = new Thread(d::method2);
    t1.start();
    t2.start();

    t1.join(2000);
    t2.join(2000);
    if (t1.isAlive() || t2.isAlive()) {
      System.out.println("DEADLOCK: threads cannot make progress.");
      System.exit(1);
    }
    System.out.println("Both threads completed successfully.");
  }

  public void method1() {
    synchronized (lock1) {
      sleep(50);
      synchronized (lock2) {
        System.out.println("method1 acquired both locks");
      }
    }
  }

  public void method2() {
    synchronized (lock1) { // Same lock order as method1()
      sleep(50);
      synchronized (lock2) {
        System.out.println("method2 acquired both locks");
      }
    }
  }

  private static void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}