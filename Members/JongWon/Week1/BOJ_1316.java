package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 심화 - 그룹 단어 체크
 */
public class BOJ_1316 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      // Input N And Validation
      int N = Integer.parseInt(br.readLine());
      if (N < 1 || N > 100)
        return;

      int count = 0;

      // Word 갯수만큼
      for (int i = 0; i < N; i++) {
        // 단어가 새로 갱신될 떄마다 초기화
        Set<Character> useCase = new HashSet<>();

        String word = br.readLine().trim();
        char c = word.charAt(0);
        useCase.add(c);
        boolean isGroupWord = true;

        for (int j = 1; j < word.length(); j++) {
          char temp = word.charAt(j);
          if (c != temp) {
            if (useCase.contains(temp)) {
              isGroupWord = false;
              break;
            } else {
              c = temp;
              useCase.add(temp);
            }
          }
        }
        if (isGroupWord)
          count++;
      }
      System.out.println(count);
    }
  }
}
