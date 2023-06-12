package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문자열 - 단어의 갯수
 */
public class BOJ_1152 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int cnt = 0;
      String[] splitLine = br.readLine().trim().split(" ");
      for (int i = 0; i < splitLine.length; i++) {
        if (!splitLine[i].equals(""))
          cnt++;
      }
      System.out.println(cnt);
    }
  }
}
