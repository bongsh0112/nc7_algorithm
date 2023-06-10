import java.util.Scanner;

public class BOJ_3052 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[10];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scanner.nextInt() % 42;
    }

    int count = 1;
    boolean isDuple = false;
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] == arr[j]) {
          isDuple = true;
          break;
        }
      }
      if (isDuple == false) {
        count++;
      }
      isDuple = false;
    }
    System.out.println(count);
    scanner.close();
  }
}
