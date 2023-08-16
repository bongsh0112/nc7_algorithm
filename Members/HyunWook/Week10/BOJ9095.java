// 9095 - 1, 2, 3 더하기

import java.util.Scanner;;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수

		// n을 1, 2, 3의 합으로 나타내는 방법의 수를 저장하는 배열
		int[] dp = new int[11];

		// 초기값 설정
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		// dp 배열 계산
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		for (int j = 0; j < T; j++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
		sc.close();
	}
}
