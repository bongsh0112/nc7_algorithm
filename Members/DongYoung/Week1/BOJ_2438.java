import java.util.Scanner;

public class bj2438 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int num = 0;

    for (int i = 0; i < n; i++) {
      num++;
      String str = "";
      for (int j = 0; j < num; j++) {
        str = str + '*';
      }
      System.out.println(str);

    }
    scanner.close();
  }
}
