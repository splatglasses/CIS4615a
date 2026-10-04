/*
 * Rule 04. Characters and Strings (STR)
 * Example: STR03-J. Do not encode noncharacter data as a string
 * Compliant Solution
 */
import java.math.BigInteger;

public class R04_STR03_J_Fixed {

  public static void main(String[] args) {
    BigInteger x = new BigInteger("530500452766");
    String s = x.toString(); // Valid character data
    byte[] byteArray = s.getBytes();
    String ns = new String(byteArray);
    x = new BigInteger(ns);

    System.out.println("Original value:  530500452766");
    System.out.println("Recovered value: " + x);
  }
}