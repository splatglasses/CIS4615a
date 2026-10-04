/*
 * Rule 08. Visibility and Atomicity (VNA)
 * Example: VNA02-J. Ensure that compound operations on shared variables are atomic
 * Non-compliant Code Example
 */
import java.util.ArrayList;
import java.util.List;

public class R08_VNA02_J {

  public static void main(String[] args) throws InterruptedException {
    Counter counter = new Counter();
    int numThreads = 1000;
    int iterations = 10000;

    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
      Thread t = new Thread(() -> {
        for (int j = 0; j < iterations; j++) {
          counter.increment();
        }
      });
      threads.add(t);
      t.start();
    }
    for (Thread t : threads) {
      t.join();
    }

    System.out.println("Expected count: " + (numThreads * iterations));
    System.out.println("Actual count:   " + counter.getValue());
  }

  static final class Counter {
    private int counter = 0;

    public void increment() {
      counter++; // Non-atomic read-modify-write
    }

    public int getValue() {
      return counter;
    }
  }
}