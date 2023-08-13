// 21921 - 블로그

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 블로그 지난 일수
		int X = Integer.parseInt(st.nextToken()); // X일 동안

		st = new StringTokenizer(br.readLine());
		int[] visitors = new int[N]; // 각 일자별 방문자 수를 저장하는 배열

		// 방문자 수를 배열에 저장
		for (int i = 0; i < N; i++) {
			visitors[i] = Integer.parseInt(st.nextToken());
		}

		int maxSum = 0; // 가장 많이 들어온 방문자 수
		int maxCount = 0; // 가장 많이 들어온 방문자 수를 가진 기간의 개수
		int currentSum = 0; // 현재 X일 동안의 방문자 수 합

		// 초기 X일 동안의 방문자 수 합 계산
		for (int i = 0; i < X; i++) {
			currentSum += visitors[i];
		}

		// 연속적인 X일 동안의 방문자 수를 비교하면서 최대값과 그 개수를 찾음
		for (int i = 0; i <= N - X; i++) {
			if (currentSum > maxSum) {
				maxSum = currentSum;
				maxCount = 1;
			} else if (currentSum == maxSum) {
				maxCount++;
			}

			// 현재 X일 동안의 방문자 수 합에서 가장 오래된 일자의 방문자 수를 뺌
			currentSum -= visitors[i];
			// 만약 배열의 범위 내에 다음 일자가 있다면 그 일자의 방문자 수를 더함
			if (i + X < N) {
				currentSum += visitors[i + X];
			}
		}

		// 가장 많이 들어온 방문자 수가 0이라면 "SAD" 출력
		if (maxSum == 0) {
			System.out.println("SAD");
		} else {
			// 가장 많이 들어온 방문자 수와 그 기간의 개수 출력
			System.out.println(maxSum);
			System.out.println(maxCount);
		}
	}
}
