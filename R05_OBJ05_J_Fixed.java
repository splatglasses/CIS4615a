/*
 * Rule 05. Object Orientation (OBJ)
 * Example: OBJ05-J. Defensively copy private mutable class members before returning their references
 * Compliant Solution
 */
import java.util.Date;

public class R05_OBJ05_J_Fixed {

  private Date date;

  public R05_OBJ05_J_Fixed(Date d) {
    date = new Date(d.getTime()); // Copy-in
  }

  public Date getDate() {
    return new Date(date.getTime()); // Copy-out
  }

  public static void main(String[] args) {
    Date d = new Date(1000000000000L);
    R05_OBJ05_J_Fixed holder = new R05_OBJ05_J_Fixed(d);

    // The external mutation no longer affects the internal state.
    d.setTime(0L);
    System.out.println("Internal date after external mutation: " + holder.getDate());
  }
}