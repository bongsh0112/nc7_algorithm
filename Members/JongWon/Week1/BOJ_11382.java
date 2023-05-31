package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 꼬마 정민
 * A + B + C
 */
public class BOJ_11382 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String[] numAry = br.readLine().split(" ");
      long A = Long.parseLong(numAry[0]);
      long B = Long.parseLong(numAry[1]);
      long C = Long.parseLong(numAry[2]);
      System.out.println(A + B + C);
    }
  }
}
