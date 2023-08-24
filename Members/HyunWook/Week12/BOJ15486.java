// 15486 - 퇴사 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] T = new int[N + 1]; // 소요 시간
    int[] P = new int[N + 1]; // 이익

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[N + 2]; // 각 날짜별 최대 이익을 저장하는 배열

    // 뒤에서부터 최대 이익을 계산
    for (int i = N; i >= 1; i--) {
      int nextDay = i + T[i]; // 해당 상담을 수행했을 때 종료되는 날짜
      // 상담을 수행하거나, 수행하지 않는 경우 중 최대 이익을 선택
      dp[i] = Math.max(dp[i + 1], nextDay <= N + 1 ? P[i] + dp[nextDay] : dp[i + 1]);
    }
    System.out.println(dp[1]); // 첫째 날부터 최대 이익 출력
  }
}
