import java.util.Scanner;

public class BOJ_10988 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String inputString = scanner.nextLine();
    boolean isPalin = true;
    int size = inputString.length();
    for (int i = 0; i < size / 2; i++) {
      if (inputString.charAt(i) != inputString.charAt(size - i - 1)) {
        isPalin = false;
      }
    }
    if (isPalin) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }
    scanner.close();
  }
}