// 2015 수들의 합4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N은 주어진 수열의 길이
		K = Integer.parseInt(st.nextToken()); // K는 부분 수열의 합이 되어야 하는 값

		int[] arr = new int[N + 1]; // arr 배열은 주어진 수열을 저장하는 배열
		int[] psum = new int[N + 1]; // psum 배열은 인덱스 i까지의 부분 합을 저장하는 배열

		st = new StringTokenizer(br.readLine());

		// psum[i]는 arr[1]부터 arr[i]까지의 합
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			psum[i] = psum[i - 1] + arr[i];
		}
		// HashMap 객체 map을 생성하고 초기값으로 (0, 1)을 넣습니다.
		// 이는 부분 합이 0인 경우는 기본적으로 1개의 부분 수열이 존재한다는 의미
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		long ret = 0; // 결과를 저장할 변수 ret을 0으로 초기화

		// N번째까지 반복문을 실행하면서 부분 합을 계산하고 결과를 ret에 누적
		for (int i = 1; i <= N; i++) {
			// map.getOrDefault(psum[i] - K, 0)를 통해 현재 부분 합에서 K를 뺀 값의 개수를 가져옵니다.
			// 이를 ret에 더해줍니다.
			ret += map.getOrDefault(psum[i] - K, 0);

			// map.put(psum[i], map.getOrDefault(psum[i], 0) + 1)을 통해 현재 부분 합의 개수를 1 증가시킵니다.
			// 이는 이전에 나온 부분 합과 현재 부분 합이 같은 경우를 계산하기 위함입니다.
			map.put(psum[i], map.getOrDefault(psum[i], 0) + 1);
		}
		// 모든 반복이 완료되면 ret에는 부분 합이 K가 되는 경우의 수가 저장되어 있습니다
		System.out.println(ret);
	}
}
