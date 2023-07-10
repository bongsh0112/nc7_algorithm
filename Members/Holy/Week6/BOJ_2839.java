package Members.Holy.Week6;

import java.io.*;
import java.util.*;

public class BOJ_2839 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            int result = sugarDelivery(N);
            System.out.println(result);
        }

        public static int sugarDelivery(int N) {
            int[] dp = new int[N + 1];  //dp[i]는 무게 i일 때 필요한 최소한의 봉지 수를 저장
            int INF = Integer.MAX_VALUE;

            // 초기값 설정 3kg과 5kg 봉지만으로 만들 수 있는 경우
            dp[3] = 1;
            dp[5] = 1;

            // Bottom-up 방식으로 동적 계획법 수행
            for (int i = 6; i <= N; i++) {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }

            return dp[N] >= INF ? -1 : dp[N]; // dp[N]이 INF보다 크거나 같으면 -1을, 그렇지 않으면 dp[N]을 반환
        }
}