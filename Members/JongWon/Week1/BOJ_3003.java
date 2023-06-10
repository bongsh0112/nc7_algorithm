package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 심화 - 킹, 퀸, 룩, 비숍, 나이트, 폰
 * Input - 킹 퀸 룩 비숍 나이트 폰의 순서
 */
public class BOJ_3003 {
  // 킹 퀸 룩 비숍 나이트 폰의 순서
  private static int[] VALID_ARY = { 1, 1, 2, 2, 2, 8 };

  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] param = br.readLine().split(" ");
      // int[] answer = new int[param.length];

      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < param.length; i++) {
        // Convert N And Validation
        int N = Integer.parseInt(param[i]);
        if (N < 0 || N > 10)
          return;

        sb.append((VALID_ARY[i] - N) + " ");
      }
      System.out.println(sb.toString());
    }
  }
}
