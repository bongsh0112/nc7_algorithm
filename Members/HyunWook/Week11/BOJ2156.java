// 2156 - 포도주 시식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 포도주 잔의 개수

		int[] wine = new int[n + 1]; // 포도주의 양을 저장하는 배열
		int[] dp = new int[n + 1]; // 각 잔까지의 최대 포도주 양을 저장하는 배열

		// 각 포도주 잔에 대한 양을 입력받아 배열에 저장
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		// 예외 처리: 1번째 잔을 선택한 경우와 2번째 잔을 선택한 경우 초기화
		if (n >= 1)
			dp[1] = wine[1]; // 한 잔인 경우
		if (n >= 2)
			dp[2] = wine[1] + wine[2]; // 두 잔인 경우

		// 3번째 잔부터 n번째 잔까지 최대 포도주 양 계산
		for (int i = 3; i <= n; i++) {
			// 현재 잔을 선택하지 않는 경우, 바로 이전 잔을 선택한 경우, 두 잔 전 잔과 현재 잔을 선택한 경우 중 최대값 선택
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
		}
		int maxWine = dp[n]; // 마지막 잔까지의 최대 포도주 양
		System.out.println(maxWine);

		br.close();

	}
}