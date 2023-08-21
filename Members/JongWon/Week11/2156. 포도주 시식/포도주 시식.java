import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] podojuNim = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      podojuNim[i] = Integer.parseInt(br.readLine());
    }

    if (N <= 2) {
      System.out.println(Arrays.stream(podojuNim).sum());
      return;
    }

    int[] dp = new int[N + 1];
    dp[1] = podojuNim[1];
    dp[2] = podojuNim[2] + dp[1];
    for (int i = 3; i <= N; i++) {
      dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + podojuNim[i - 1], dp[i - 2]) + podojuNim[i]);
    }
    System.out.println(dp[N]);
  }
}
