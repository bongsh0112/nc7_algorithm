import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n+1];
    int[] data = new int[n+1];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      data[i] = Integer.parseInt(st.nextToken());
      dp[i] = data[i];
    }

    int ret = dp[1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        if (data[j] < data[i]) {
          dp[i] = Math.max(dp[j] + data[i], dp[i]);
          ret = Math.max(ret, dp[i]);
        }
      }
    }
    System.out.println(ret);
  }
}
