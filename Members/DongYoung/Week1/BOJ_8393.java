import java.util.Scanner;

public class BOJ_8393 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    System.out.println((n * (n + 1)) / 2);
    scanner.close();
  }
}
