package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 윤년
 * 윤년인 경우 출력을 1, 아니면 0을 입력한다.
 * 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
 */
public class BOJ_2753 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int year = Integer.parseInt(br.readLine());

      if (year % 400 == 0) {
        System.out.println("1");
        return;
      }

      if ((year % 100 != 0) && (year % 4 == 0)) {
        System.out.println("1");
        return;
      }
      System.out.println("0");
    }
  }
}
