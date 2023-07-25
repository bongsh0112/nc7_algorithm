// 16139 - 인간-컴퓨터 상호작용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문제에서 문자열의 길이가 최대 200,000자 이하라고 하였으므로, readLine()을 사용하여 한 줄의 입력을 받습니다.
		String S = br.readLine();
		// 질문의 개수 q를 정수형으로 입력받습니다.
		int q = Integer.parseInt(br.readLine());

		// 각 알파벳의 누적 등장 횟수를 저장하는 배열
		// 26은 알파벳 소문자 개수이며, S.length() + 1은 문자열 S의 길이보다 한 칸 크게 잡아서 인덱스 0부터 시작하도록 합니다.
		int[][] cumulativeCount = new int[26][S.length() + 1];

		// 문자열 S를 순회하며 누적 등장 횟수를 계산하여 배열에 저장
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			for (int j = 0; j < 26; j++) {
				cumulativeCount[j][i + 1] = cumulativeCount[j][i];
			}
			cumulativeCount[ch - 'a'][i + 1]++;
		}

		StringBuilder sb = new StringBuilder();

		// 각 질문에 대해 결과를 StringBuilder에 추가
		for (int i = 0; i < q; i++) {
			// 각 질문은 알파벳과 구간 [l, r]로 주어지기 때문에 input 배열의 첫 번째 요소는 알파벳,
			// 두 번째 요소는 l, 세 번째 요소는 r에 저장됩니다.
			String[] input = br.readLine().split(" ");
			char alpha = input[0].charAt(0);
			int l = Integer.parseInt(input[1]);
			int r = Integer.parseInt(input[2]);

			// 알파벳이 소문자 알파벳이므로 알파벳 'a'의 ASCII 값이 97이므로,
			// alpha - 'a'로 알파벳에 해당하는 인덱스를 구할 수 있습니다.
			// cumulativeCount[alpha - 'a'][r + 1] - cumulativeCount[alpha - 'a'][l]로 해당
			// 구간에서 알파벳이 등장한 횟수를 계산
			int count = cumulativeCount[alpha - 'a'][r + 1] - cumulativeCount[alpha - 'a'][l];
			sb.append(count).append("\n");
		}

		System.out.print(sb);
	}
}
