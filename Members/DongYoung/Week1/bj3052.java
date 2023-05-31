import java.util.Scanner;

public class bj3052 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[10];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scanner.nextInt() % 42;
    }

    int count = 1;
    boolean isDuple = false;
    for (int i = 1; i < arr.length; i++) {
      System.out.println(i);
      for (int j = 0; j < i; j++) {
        System.out.println(arr[i]);
        if (arr[i] == arr[j]) {
          isDuple = true;
          continue;
        }
      }
      if (isDuple == false) {
        count++;
      }
      isDuple = false;
    }
    System.out.println(count);
  }
}
