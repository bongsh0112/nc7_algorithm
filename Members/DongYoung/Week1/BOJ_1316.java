import java.util.Scanner;

public class BOJ_1316 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int N = scanner.nextInt();
    scanner.nextLine();

    int count = N;
    String word = "";

    for (int i = 0; i < N; i++) {
      word = scanner.nextLine();
      for (int j = 0; j < word.length(); j++) {
        boolean isGroup = true;
        boolean checkStart = false;
        for (int k = j; k < word.length(); k++) {
          if (checkStart) {
            if (word.charAt(j) == word.charAt(k)) {
              isGroup = false;
              count--;
              break;
            }
          } else {
            if (word.charAt(j) != word.charAt(k)) {
              checkStart = true;
            }
          }
        }
        if (!isGroup) {
          break;
        }
      }
    }

    System.out.println(count);
    scanner.close();
  }
}
