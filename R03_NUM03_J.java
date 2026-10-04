/*
 * Rule 03. Numeric Types and Operations (NUM)
 * Example: NUM03-J. Use integer types that can fully represent the possible range of unsigned data
 * Non-compliant Code Example
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class R03_NUM03_J {

  public static void main(String[] args) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);
    dos.writeInt(0xFFFFFFFF); // unsigned value 4,294,967,295
    dos.close();

    DataInputStream is = new DataInputStream(new ByteArrayInputStream(baos.toByteArray()));
    int x = getInteger(is);
    System.out.println("Value read from stream: " + x);
  }

  public static int getInteger(DataInputStream is) throws IOException {
    return is.readInt();
  }
}