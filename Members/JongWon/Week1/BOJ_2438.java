package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 반복문 - 별 찍기 1
 */
public class BOJ_2438 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int N = Integer.parseInt(br.readLine());

      if (N < 1 || N > 100) {
        return;
      }

      StringBuffer sb = new StringBuffer();
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= i; j++) {
          sb.append("*");
        }
        sb.append("\n");
      }
      System.out.println(sb.toString());
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
