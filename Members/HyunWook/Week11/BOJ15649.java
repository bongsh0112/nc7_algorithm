// 15649 - N과 M(1)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] sequence;
	static boolean[] used;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 전체 숫자 범위
		M = Integer.parseInt(input[1]); // 선택할 숫자 개수

		sequence = new int[M]; // 선택한 숫자를 저장할 배열
		used = new boolean[N + 1]; // 이미 사용한 숫자를 표시할 배열

		generateSequence(0); // 0번째 위치부터 시작

		br.close();
	}

	static void generateSequence(int index) {
		if (index == M) { // M개의 숫자를 선택했을 때
			for (int num : sequence) {
				System.out.println(num + " ");
			}
			System.out.println(); // 한 줄 출력 후 줄바꿈
			return;
		}
		for (int i = 1; i <= N; i++) { // 1부터 N까지의 숫자를 순회하며
			if (!used[i]) { // 숫자 i가 사용되지 않았다면
				sequence[index] = i; // 해당 위치에 숫자 i를 선택한 것으로 기록
				used[i] = true; // 숫자 i를 사용했다고 표시
				generateSequence(index + 1); // 다음 위치를 선택하기 위해 재귀 호출
				used[i] = false; // 이전 상태로 돌려놓음
			}
		}
	}
}