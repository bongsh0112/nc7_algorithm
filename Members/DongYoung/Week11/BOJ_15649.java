package Members.DongYoung.Week11;

import java.util.Scanner;
import java.util.ArrayList;

public class BOJ_15649 {

  static ArrayList<ArrayList<Integer>> list;
  static StringBuffer sb = new StringBuffer("");

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int M = scanner.nextInt();

    int[] init = new int[N];
    for (int i = 0; i < init.length; i++) {
      init[i] = i + 1;
    }
    recursive(new int[] {}, init, N, M);
    System.out.println(sb.toString());

  }

  public static void recursive(int[] arr, int[] remain, int N, int M) {
    if (arr.length == M) {
      for (int i = 0; i < arr.length; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
    } else {
      for (int i = 0; i < remain.length; i++) {
        int[] addArr = new int[arr.length + 1];
        for (int j = 0; j < addArr.length - 1; j++) {
          addArr[j] = arr[j];
        }
        addArr[addArr.length - 1] = remain[i];

        int[] addRemain = new int[remain.length - 1];
        int cnt = 0;
        for (int j = 0; j < remain.length; j++) {
          if (remain[i] != remain[j]) {
            addRemain[cnt] = remain[j];
            cnt++;
          }
        }

        recursive(addArr, addRemain, N, M);
      }
    }

  }
}
