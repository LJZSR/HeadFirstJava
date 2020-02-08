import java.io.*;

public class WriteAFile {
  public static void main(String[] args) {
    try {
      FileWriter fw = new FileWriter("Foo.txt");
      fw.write("Hello Foo!");
      fw.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}