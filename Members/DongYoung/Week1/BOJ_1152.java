import java.util.Scanner;

public class BOJ_1152 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String strings = scanner.nextLine();
    if (strings.charAt(0) == ' ') {
      if (strings.length() > 1) {
        strings = strings.substring(1);
      }
    }
    if (strings.charAt(strings.length() - 1) == ' ') {
      if (strings.length() > 1) {
        strings = strings.substring(0, (strings.length() - 1));
      }
    }
    var ans = strings.split(" ");

    System.out.println(ans.length);
    scanner.close();
  }

}
