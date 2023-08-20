// 1789 - 수들의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine()); // 입력으로 주어진 합 S

		long N = 1; // 자연수 N 초기화
		while (N * (N + 1) / 2 <= S) {
			N++;
		}
		System.out.println(N - 1); // N - 1이 최댓값
		br.close();
	}
}