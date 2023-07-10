import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] grade = new int[N];
    int[] dp = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      grade[i] = Integer.parseInt(st.nextToken());
    }

    int num = 0;
    for (int i = 1; i < N; i++) {
      if (grade[i - 1] > grade[i]) {
        num++;
      }
      dp[i] = num;
    }
    StringBuilder sb = new StringBuilder();
    int tc = Integer.parseInt(br.readLine());
    for (int loop = 0; loop < tc; loop++) {
      String[] sted = br.readLine().split(" ");
      int stNum = Integer.parseInt(sted[0]) - 1;
      int edNum = Integer.parseInt(sted[1]) - 1;

      sb.append(dp[edNum] - dp[stNum] + "\n");
    }
    System.out.println(sb);
  }
}