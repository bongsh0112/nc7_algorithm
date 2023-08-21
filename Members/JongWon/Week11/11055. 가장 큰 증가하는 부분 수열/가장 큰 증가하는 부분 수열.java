import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int A = Integer.parseInt(br.readLine());
    int[] score = new int[A + 1];
    int[] dp = new int[A + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= A; i++)
      score[i] = Integer.parseInt(st.nextToken());

    dp[1] = score[1];
    for (int i = 2; i <= A; i++) {
      dp[i] = score[i];
      for (int j = 1; j < i; j++) {
        if (score[i] > score[j]) {
          dp[i] = Math.max(dp[j] + score[i], dp[i]);
        }
      }
    }
    System.out.println(Arrays.stream(dp).max().getAsInt());
  }
}
