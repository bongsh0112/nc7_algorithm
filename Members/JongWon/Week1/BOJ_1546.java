package Members.JongWon.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1546 {
  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int N = Integer.parseInt(br.readLine());
      // validation

      if (N < 0 || N > 1000)
        return;

      String[] scoreLine = br.readLine().split(" ");
      int[] score = new int[N];
      int M = 0;
      double scoreSum = 0;

      for (int i = 0; i < N; i++) {
        score[i] = Integer.parseInt(scoreLine[i]);
        M = Math.max(M, score[i]);
      }
      for (int i = 0; i < N; i++) {
        double convertScore = (score[i] / (double) M) * 100;
        scoreSum += convertScore;
      }

      System.out.println(scoreSum / N);
    }
  }
}
