// 20543 폭탄 던지는 태영이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[][] univ;
	static long[][] ans;
	static int N, M;

	// main 함수에서는 입력을 받고, univ와 ans라는 두 개의 2차원 배열을 선언합니다.
	// N과 M은 주어진 수와 부분 배열의 크기를 나타냅니다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" "); // 한 줄에 N과 M을 함께 입력받아야 합니다.
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		univ = new long[N][N];
		ans = new long[N][N];

		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				try {
					long num = Long.parseLong(row[j]);
					univ[i][j] = -1 * num;
				} catch (NumberFormatException e) {
					System.out.println("잘못된 입력입니다.");
					return;
				}
			}
		}

		solve();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	// solve 함수에서는 중첩된 반복문을 사용하여 ans 배열을 계산합니다.
	// r은 M의 절반 값을 의미하며, 부분 배열의 시작과 끝 인덱스를 계산하는 데 사용됩니다.
	public static void solve() {
		int r = M / 2;
		int start = r;
		int end = N - r;

		// solve 함수의 반복문 내에서는 univ 배열에서 ans 배열로 값을 복사합니다.
		// 이때, 부분 배열의 합을 계산하는 데에도 사용됩니다.
		for (int i = start; i < end; i++) {
			for (int j = start; j < end; j++) {
				ans[i][j] = univ[i - r][j - r];
				if (i - r - 1 >= 0)
					ans[i][j] -= univ[i - r - 1][j - r];
				if (j - r - 1 >= 0)
					ans[i][j] -= univ[i - r][j - r - 1];
				if (i - r - 1 >= 0 && j - r - 1 >= 0)
					ans[i][j] += univ[i - r - 1][j - r - 1];
				if (i - M >= 0)
					ans[i][j] += ans[i - M][j];
				if (j - M >= 0)
					ans[i][j] += ans[i][j - M];
				if (i - M >= 0 && j - M >= 0)
					ans[i][j] -= ans[i - M][j - M];
			}
		}
	}
}
