// 15651 - N과 M(3)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] selected; // 선택한 숫자를 저장할 배열
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 1부터 N까지의 자연수 중에서
		M = Integer.parseInt(st.nextToken()); // 중복을 허용하여 M개를 고르는 경우

		selected = new int[M]; // M개를 저장하는 배열 생성
		permutation(0); // 재귀적으로 순열 생성 시작 - 순열 : permutation

		System.out.println(sb.toString());
	}

	static void permutation(int depth) {
		if (depth == M) { // M개를 선택한 경우 결과를 출력하고 종료
			for (int num : selected) {
				sb.append(num).append(" "); // 결과에 선택한 숫자 추가
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) { // 1부터 N까지의 숫자 중에서 선택
			selected[depth] = i; // 선택한 숫자를 배열에 저장
			permutation(depth + 1); // 다음 숫자 선택을 위해 재귀 호출
		}
	}
}