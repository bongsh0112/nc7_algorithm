import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      if (a == 0 || b == 0) {
        break;
      }
      System.out.println(a + b);
    }
    sc.close();
  }
}