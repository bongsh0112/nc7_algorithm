// 1749 점수 따먹기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, M, board[][], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N은 보드의 행 수
		M = Integer.parseInt(st.nextToken()); // M은 보드의 열 수
		board = new int[N + 1][M + 1]; // board 배열은 게임 보드의 값들을 저장하는 배열
		dp = new int[N + 1][M + 1]; // dp 배열은 각 위치까지의 누적 점수를 저장하는 배열

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 그 후, 이중 반복문을 통해 dp 배열을 계산합니다. 각 위치까지의 누적 점수는 이전 행까지의 누적 점수,
		// 이전 열까지의 누적 점수, 그리고 이전 행과 열까지의 누적 점수를 사용하여 계산됩니다.
		// 이를 통해 dp 배열이 갱신됩니다.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + board[i][j];
			}
		}
		long max = Integer.MIN_VALUE;
		// 다시 이중 반복문을 통해 모든 가능한 부분 보드를 확인하면서 점수를 계산합니다.
		// i와 j는 부분 보드의 시작 위치를 의미하고, x와 y는 부분 보드의 끝 위치를 의미합니다.
		// prefixSum 메서드를 호출하여 부분 보드의 점수를 계산하고, max와 비교하여 최대 점수를 갱신합니다.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				for (int x = i; x <= N; x++) {
					for (int y = j; y <= M; y++) {
						long result = prefixSum(i, j, x, y, dp);
						max = Math.max(max, result);
					}
				}
			}
		}
		System.out.println(max);
	}

	static long prefixSum(int x1, int y1, int x2, int y2, int[][] psum) {
		return psum[x2][y2] - psum[x1 - 1][y2] - psum[x2][y1 - 1] + psum[x1 - 1][y1 - 1];
	}
}
