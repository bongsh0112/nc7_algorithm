package Members.DongYoung.Week6;

import java.util.Scanner;
import java.lang.Math;
import java.lang.StringBuffer;

public class BOJ_20543 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int M = scanner.nextInt();
    if (M % 2 == 0) {
      return;
    }
    scanner.nextLine();
    int[][] arr = new int[N + 1][N + 1];
    int[][] ans = new int[N + 1][N + 1];
    long[][] sum = new long[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      String[] splitStr = scanner.nextLine().split(" ");
      if (i > (N - (M / 2) * 2)) {
        continue;
      }
      for (int j = 1; j <= N - M / 2 * 2; j++) {
        arr[i][j] = Integer.parseInt(splitStr[j - 1]);
        // 4개로 분리해서 구해보자
        sum[i + M / 2][j + M / 2] = (int) -arr[i][j]
            + sum[Math.max(0, i - 1 - M / 2)][j + M / 2]
            + sum[i + M / 2][Math.max(0, j - 1 - M / 2)]
            - sum[Math.max(0, i - 1 - M / 2)][Math.max(0, j - 1 - M / 2)];

        ans[i + M / 2][j + M / 2] = (int) (sum[i + M / 2][j + M / 2]
            - sum[i - 1 + M / 2][j + M / 2]
            - sum[i + M / 2][j - 1 + M / 2]
            + sum[i - 1 + M / 2][j - 1 + M / 2]);

      }
    }
    StringBuffer sb = new StringBuffer("");
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        sb.append(ans[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
  }
}
