import java.util.Scanner;

public class BOJ_11654 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String intputStr = scanner.nextLine();
    short ans = (short) intputStr.charAt(0);

    System.out.println(ans);
    scanner.close();
  }
}
