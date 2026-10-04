/*
 * Rule 05. Object Orientation (OBJ)
 * Example: OBJ05-J. Defensively copy private mutable class members before returning their references
 * Non-compliant Code Example
 */
import java.util.Date;

public class R05_OBJ05_J {

  private Date date;

  public R05_OBJ05_J(Date d) {
    date = d;
  }

  public Date getDate() {
    return date;
  }

  public static void main(String[] args) {
    Date d = new Date(1000000000000L);
    R05_OBJ05_J holder = new R05_OBJ05_J(d);

    // External code mutates the Date through the reference it kept,
    // corrupting the object's internal state.
    d.setTime(0L);
    System.out.println("Internal date after external mutation: " + holder.getDate());
  }
}