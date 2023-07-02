// 11660 구간 합 구하기5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // N은 2차원 배열의 크기를 나타내는 변수입니다.
    int M = Integer.parseInt(st.nextToken()); // M은 구간 합을 계산할 횟수를 나타내는 변수입니다.

    int[][] arr = new int[N + 1][N + 1]; // arr은 입력받은 2차원 배열을 저장하는 배열입니다.

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dp = new int[N + 1][N + 1]; // dp는 부분 합을 저장하는 2차원 배열입니다. N + 1 크기로 초기화합니다.
    StringBuilder sb = new StringBuilder(); // sb는 결과를 저장하기 위한 객체
    // 이중 반복문을 통해 dp 배열을 구성합니다.
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        // dp[i][j]는 dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]의 합에
        // arr[i][j] 값을 더한 값으로 계산됩니다. 이는 2차원 배열의 부분 합을 나타냅니다.
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
      }
    }

    // M번 반복하면서 구간의 시작과 끝 인덱스를 입력받습니다.
    for (int k = 0; k < M; k++) {
      // dp 배열을 이용하여 x1, y1, x2, y2에 해당하는 구간 합을 계산합니다.
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      // sum 변수에 계산된 구간 합을 저장하고, sb에 결과를 추가합니다.
      int sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
      sb.append(sum + "\n");
    }
    // 반복이 끝난 후, sb에 저장된 결과를 출력합니다.
    System.out.println(sb);
  }
}
