import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static Integer[] dp;
  static int[] data; 
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());

    dp = new Integer[n + 1];
    data = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
      data[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = 0;
    dp[1] = data[1];

    if (n > 1) dp[2] = data[1] + data[2];

    System.out.println(recur(n));
  }

  static int recur(int n) {
    if(dp[n] == null) {
      dp[n] = Math.max(Math.max(recur(n - 2), recur(n - 3) + data[n - 1]) + data[n], recur(n - 1));
    }
    
    return dp[n];
  }
}
