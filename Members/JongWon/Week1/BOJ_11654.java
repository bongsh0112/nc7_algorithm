package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문자열 - 아스키코드
 */
public class BOJ_11654 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int num = br.readLine().charAt(0);
      System.out.println(num);
    }
  }
}
