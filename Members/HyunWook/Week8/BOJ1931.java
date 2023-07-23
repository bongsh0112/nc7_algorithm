// 1931 - 회의실 배정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 회의의 수 N
		// 각 회의의 정보를 저장할 2차원 배열 meetings를 선언합니다. (N개의 행과 2개의 열로 구성)
		int[][] meetings = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		// 회의 끝나는 시간을 기준으로 오름차순 정렬
		// 끝나는 시간이 같다면 시작 시간을 기준으로 오름차순 정렬
		// 이렇게 정렬하면 끝나는 시간이 빠른 순서대로 회의들이 정렬됩니다.
		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		// maxCount 변수를 선언하여 최대 회의 개수를 저장합니다. 초기값은 1로 설정합니다. (첫 번째 회의는 무조건 선택)
		int maxCount = 1;
		// endTime 변수를 선언하여 선택한 회의들 중 가장 최근에 끝나는 시간을 저장합니다.
		// 초기값은 첫 번째 회의의 끝나는 시간으로 설정합니다.
		int endTime = meetings[0][1];

		// 반복문을 사용하여 meetings 배열을 순회하면서 겹치지 않는 회의들을 선택합니다.
		for (int i = 1; i < N; i++) {
			// 만약 현재 회의의 시작 시간이 endTime보다 크거나 같다면 (겹치지 않는 경우),
			// maxCount를 1 증가시키고 endTime를 현재 회의의 끝나는 시간으로 갱신합니다.
			if (meetings[i][0] >= endTime) {
				maxCount++;
				endTime = meetings[i][1];
			}
		}
		// 반복문이 끝나면 maxCount에 최대 회의 개수가 저장
		System.out.println(maxCount);

	}
}
