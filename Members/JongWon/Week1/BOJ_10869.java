package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사칙연산
 * A+B, A-B, A*B, A/B(몫), A%B(나머지)
 */
public class BOJ_10869 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] numAry = br.readLine().split(" ");
      int A = Integer.parseInt(numAry[0]);
      int B = Integer.parseInt(numAry[1]);

      StringBuffer sb = new StringBuffer((A + B) + "\n")
          .append((A - B) + "\n")
          .append((A * B) + "\n")
          .append((A / B) + "\n")
          .append((A % B) + "\n");

      System.out.println(sb.toString());
    }
  }
}