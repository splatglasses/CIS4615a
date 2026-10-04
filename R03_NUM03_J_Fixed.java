/*
 * Rule 03. Numeric Types and Operations (NUM)
 * Example: NUM03-J. Use integer types that can fully represent the possible range of unsigned data
 * Compliant Solution
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class R03_NUM03_J_Fixed {

  public static void main(String[] args) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);
    dos.writeInt(0xFFFFFFFF); // unsigned value 4,294,967,295
    dos.close();

    DataInputStream is = new DataInputStream(new ByteArrayInputStream(baos.toByteArray()));
    long x = getInteger(is);
    System.out.println("Value read from stream: " + x);
  }

  public static long getInteger(DataInputStream is) throws IOException {
    return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits
  }
}