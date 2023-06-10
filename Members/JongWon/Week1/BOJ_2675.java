package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문자열 - 문자열 반복
 */
public class BOJ_2675 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringBuffer sb = new StringBuffer();

      // T Input And Valid
      int T = Integer.parseInt(br.readLine());
      if (T < 1 || T > 1000) {
        return;
      }

      for (int i = 0; i < T; i++) {
        String[] splitLine = br.readLine().split(" ");
        String word = splitLine[1];

        // Cast R And Valid
        int R = Integer.parseInt(splitLine[0]);
        if (R < 1 || R > 8) {
          return;
        }
        // n의 3승인데 최대 계수가 1000 * 20 * 8이라서 최대 명령수행이 약 16만회, 1초미만으로 추측되서 사용함
        for (int j = 0; j < word.length(); j++) {
          for (int loop = 0; loop < R; loop++) {
            sb.append(word.charAt(j));
          }
        }

        sb.append("\n");
      }

      System.out.println(sb.toString());
    }
  }
}
