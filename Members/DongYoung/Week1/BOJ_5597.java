import java.util.Scanner;
import java.util.Arrays;

public class BOJ_5597 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] arr1 = new int[30];
    int[] arr2 = new int[28];

    for (int i = 0; i < 28; i++) {
      arr2[i] = scanner.nextInt() - 1;
    }

    Arrays.fill(arr1, 1);
    for (int i = 0; i < arr2.length; i++) {
      arr1[arr2[i]] = 0;
    }

    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] == 1) {
        System.out.println(i + 1);
      }
    }
    scanner.close();
  }
}
