// 10844 - 쉬운 계단 수

import java.util.Scanner;;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 계단의 개수

		long[][] dp = new long[n + 1][10]; // dp[i][j]: 길이가 i이고 마지막 자릿수가 j인 계단 수 개수
		long MOD = 1000000000L;

		// 길이가 1인 계단 수 초기화
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		// 길이가 2 이상인 계단 수 계산
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1] % MOD;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][8] % MOD;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
				}
			}
		}
		long answer = 0;
		for (int i = 0; i <= 9; i++) {
			answer = (answer + dp[n][i]) % MOD;
		}
		System.out.println(answer);
	}
}
