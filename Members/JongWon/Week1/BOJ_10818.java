package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1차원배열 - 최소, 최대
 */
public class BOJ_10818 {

  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int N = Integer.parseInt(br.readLine());
      if (N < 1 || N > 1000000) {
        return;
      }
      String[] numSplitAry = br.readLine().split(" ");
      int max = Integer.parseInt(numSplitAry[0]);
      int min = Integer.parseInt(numSplitAry[0]);
      for (int i = 1; i < N; i++) {
        int num = Integer.parseInt(numSplitAry[i]);
        max = Math.max(max, num);
        min = Math.min(min, num);
      }

      System.out.println(min + " " + max);
    }
  }
}
