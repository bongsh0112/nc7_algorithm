// 7568 - 덩치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 전체 사람의 수
		int[] weights = new int[N]; // 각 사람의 몸무게를 저장하는 배열
		int[] heights = new int[N]; // 각 사람의 키를 저장하는 배열
		int[] ranks = new int[N]; // 각 사람의 덩치 등수를 저장하는 배열

		// 각 사람의 몸무게와 키를 입력받아서 배열에 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			heights[i] = Integer.parseInt(st.nextToken());
			ranks[i] = 1; // 초기 등수는 1로 설정
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (weights[i] < weights[j] && heights[i] < heights[j]) {
					ranks[i]++;
				}
			}
		}
		// 덩치 등수를 공백으로 구분하여 StringBuilder에 추가
		for (int i = 0; i < N; i++) {
			sb.append(ranks[i]).append(" ");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
