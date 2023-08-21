package Members.DongYoung.Week11;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class BOJ_10815 {

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bf.readLine());
    int[] arr = new int[N];

    String[] split = bf.readLine().split(" ");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(split[i]);
    }
    int M = Integer.parseInt(bf.readLine());
    int[] arr1 = new int[M];
    int[] ans = new int[M];
    split = bf.readLine().split(" ");
    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = Integer.parseInt(split[i]);
    }
    Arrays.sort(arr);
    loop1: for (int i = 0; i < M; i++) {
      int start = 0;
      int end = N - 1;
      while (start <= end) {
        int center = (start + end) / 2;
        if (arr1[i] == arr[center]) {
          ans[i] = 1;
          continue loop1;
        } else if (arr1[i] > arr[center]) {
          start = center + 1;
        } else {
          end = center - 1;
        }
      }
      ans[i] = 0;
    }
    for (int i : ans) {
      System.out.print(i + " ");
    }

  }
}
