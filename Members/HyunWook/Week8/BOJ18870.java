// 18870 - 좌표 압축

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] X = new int[N];

		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(input[i]);
		}
		// 배열을 복사하여 정렬하여 중복된 값을 제거하고, 각 값에 대해 압축된 결과를 구함
		int[] sortedX = X.clone();
		Arrays.sort(sortedX);

		Map<Integer, Integer> compressionMap = new HashMap<>();
		int idx = 0;

		for (int i = 0; i < N; i++) {
			if (!compressionMap.containsKey(sortedX[i])) {
				compressionMap.put(sortedX[i], idx++);
			}
		}
		// 압축된 결과를 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(compressionMap.get(X[i])).append(" ");
		}
		System.out.println(sb.toString());

	}
}
