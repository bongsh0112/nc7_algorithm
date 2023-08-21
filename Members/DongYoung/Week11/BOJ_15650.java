package Members.DongYoung.Week11;

import java.util.Scanner;

public class BOJ_15650 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int M = scanner.nextInt();

    recursive(new int[] {}, N, M);

  }

  public static void recursive(int[] arr, int N, int M) {
    if (arr.length == M) {
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    } else if (arr.length == 0) {
      for (int i = 1; i <= N; i++) {
        recursive(new int[] { i }, N, M);
      }
      return;
    } else {
      for (int i = arr[arr.length - 1] + 1; i <= N; i++) {
        int[] addArr = new int[arr.length + 1];
        for (int j = 0; j < addArr.length - 1; j++) {
          addArr[j] = arr[j];
        }
        addArr[addArr.length - 1] = i;
        recursive(addArr, N, M);
      }

    }

  }
}
