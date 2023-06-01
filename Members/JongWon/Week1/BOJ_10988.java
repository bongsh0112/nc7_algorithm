package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 심화 - 팰린드롬인지 확인하기
 * 팰린드롬이란? 반갈죽해서 같은 문자열의 배치를 의미함.
 */
public class BOJ_10988 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String str = br.readLine().trim();
      int loop = str.length() / 2;

      boolean isPalindrome = true;

      // 가운데는 안하기 떄문에 /2를 해도 상관없슴.
      for (int i = 1; i <= loop; i++) {
        if (str.charAt(i - 1) != str.charAt(str.length() - i)) {
          isPalindrome = false;
          break;
        }
      }

      System.out.println(isPalindrome ? 1 : 0);

    }
  }
}
