// 2579 - 계단 오르기

import java.util.Scanner;;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 계단의 개수

		int[] stairs = new int[n + 1]; // 각 계단의 점수를 저장할 배열
		int[] dp = new int[n + 1]; // 동적 계획법(dp)을 위한 배열

		// 각 계단의 점수 입력 받기
		for (int i = 1; i < n + 1; i++) {
			stairs[i] = sc.nextInt();
		}
		dp[0] = 0; // 초기값 설정
		dp[1] = stairs[1];

		if (n >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}
		// dp를 통해 최대 점수 계산
		for (int i = 3; i < n + 1; i++) {
			// 각 위치 i에서의 최대 점수는 stairs[i] + stairs[i - 1] + dp[i - 3]과
			// stairs[i] + dp[i - 2] 중 더 큰 값을 선택합니다.
			dp[i] = Math.max(stairs[i] + stairs[i - 1] + dp[i - 3], stairs[i] + dp[i - 2]);
		}
		System.out.println(dp[n]);

	}
}
