import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();

    for (int i = 0; i < a; i++) {
      for (int j = 0; j < i + 1; j++) {
        System.out.print("*");
      }
      System.out.println("");
    }
    sc.close();
  }
}