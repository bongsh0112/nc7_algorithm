package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 심화 - 평균은 넘겠지, 1초
 */
public class BOJ_4344 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringBuffer sb = new StringBuffer();

      // TestCase Input
      int C = Integer.parseInt(br.readLine());
      for (int i = 0; i < C; i++) {
        String[] splitLine = br.readLine().split(" ");

        // Cast N And Validation
        int N = Integer.parseInt(splitLine[0]);
        if (N < 1 || N > 1000)
          return;

        // 평균 구하기
        int scoreSum = 0;
        int[] scoreAry = new int[N];
        for (int j = 1; j < splitLine.length; j++) {
          scoreAry[j - 1] = Integer.parseInt(splitLine[j]);
          scoreSum += scoreAry[j - 1];
        }
        int scoreAvg = scoreSum / N;
        int count = 0;
        for (int j = 1; j < splitLine.length; j++) {
          if (scoreAry[j - 1] > scoreAvg) {
            count++;
          }
        }
        sb.append(String.format("%.3f%%\n", (count / (double) N) * 100));
      }
      System.out.println(sb.toString());
    }
  }
}
