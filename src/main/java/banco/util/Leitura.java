package banco.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Leitura {
  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public static int read() {
    try {
      return reader.read();
    } catch (Exception e) {
      return -1;
    }    
  } 

  public static String readLine() {
    try {
      return reader.readLine();
    } catch (Exception e) {
      return e.getMessage();
    }    
  } 

  public static void fechar() {
    try {
      reader.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
