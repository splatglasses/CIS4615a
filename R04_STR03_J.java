/*
 * Rule 04. Characters and Strings (STR)
 * Example: STR03-J. Do not encode noncharacter data as a string
 * Non-compliant Code Example
 */
import java.math.BigInteger;

public class R04_STR03_J {

  public static void main(String[] args) {
    BigInteger x = new BigInteger("530500452766");
    byte[] byteArray = x.toByteArray();
    String s = new String(byteArray);
    byteArray = s.getBytes();
    x = new BigInteger(byteArray);

    System.out.println("Original value:  530500452766");
    System.out.println("Recovered value: " + x);
  }
}