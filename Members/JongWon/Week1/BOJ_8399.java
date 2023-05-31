package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 반복문 - 합
 */
public class BOJ_8399 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int N = Integer.parseInt(br.readLine());

      if (N < 1 || N > 10000) {
        return;
      }
      int sum = 0;
      for (int i = 1; i <= N; i++) {
        sum += i;
      }
      System.out.println(sum);
    }
  }
}
