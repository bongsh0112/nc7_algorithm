package Members.JongWon.Week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N + 1];
    int[] sum = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum[i] = sum[i - 1] + arr[i];
    }

    long ans = 0;
    for (int i = 1; i < N; i++) {
      int v = sum[N] - sum[i];
      ans += v * arr[i];
    }
    System.out.println(ans);
  }
}
