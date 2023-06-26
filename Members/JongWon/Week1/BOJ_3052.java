package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 배열 - 나머지
 * 42로 나눈 나머지값을 구하고, 몇종류가 있는지를 출력한다.
 */
public class BOJ_3052 {
  // mod = 0~41
  public static int LINE_NUM = 10;
  public static int MOD_NUM = 42;

  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      boolean[] modAry = new boolean[42];
      Arrays.fill(modAry, false);
      int count = 0;

      for (int i = 0; i < LINE_NUM; i++) {
        int N = Integer.parseInt(br.readLine());

        if (N < 1 || N > 1000) {
          return;
        }

        int modValue = N % MOD_NUM;
        if (!modAry[modValue]) {
          modAry[modValue] = true;
          count++;
        }

      }

      System.out.println(count);
    }
  }
}
