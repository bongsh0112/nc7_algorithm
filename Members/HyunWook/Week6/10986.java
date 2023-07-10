// 10986 나머지 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // N은 주어진 수열의 길이
		int M = Integer.parseInt(st.nextToken()); // M은 부분 합의 나머지

		long[] numArr = new long[N + 1]; // numArr 배열은 주어진 수열의 누적 합을 저장하는 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			numArr[i] = numArr[i - 1] + Long.parseLong(st.nextToken());
		}

		// 반복문을 통해 numArr 배열의 각 원소를 M으로 나눈 나머지를 구합니다.
		for (int i = 1; i <= N; i++) {
			numArr[i] %= M;
		}

		// numArr 배열을 정렬합니다. 정렬을 하여 같은 나머지를 가진 원소들이 인접하도록 만듭니다.
		Arrays.sort(numArr);

		HashMap<Long, Integer> countMap = new HashMap<>();
		for (int i = 0; i <= N; i++) {
			long remainder = numArr[i] % M;
			countMap.put(remainder, countMap.getOrDefault(remainder, 0) + 1);
		}

		// 그렇지 않은 경우에는 count가 2 이상인지 확인하여,
		// 만약 그렇다면 sum에 (count * (count - 1) / 2) 값을 더합니다.
		// 나머지를 가진 원소들 중에서 2개 이상을 선택하는 경우의 수를 계산하는 것입니다.
		long sum = 0;
		for (int count : countMap.values()) {
			if (count >= 2) {
				sum += (long) count * (count - 1) / 2;
			}
		}
		// sum을 출력합니다. 이는 주어진 수열에서 부분 합의 나머지가 같은 부분 수열의 개수를 의미합니다.
		System.out.println(sum);
	}
}
