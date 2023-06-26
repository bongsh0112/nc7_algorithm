import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();

    for (int i = 1; i <= a; i++) {
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println("Case #" + i + ": " + b + " + " + c + " = " + (b + c));
    }

    sc.close();
  }
}