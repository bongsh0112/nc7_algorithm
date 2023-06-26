import java.util.*; // java.util 에서 패키지의 모든 클래스를 가져오는 것
import java.io.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int ch = sc.next().charAt(0);
    System.out.println(ch);
    sc.close();

  }
}