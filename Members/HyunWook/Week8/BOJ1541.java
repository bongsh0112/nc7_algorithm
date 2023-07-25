// 1541 - 잃어버린 괄호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 초기 상태 여부 확인을 위한 값으로 설정
		int sum = Integer.MAX_VALUE;
		// subtraction 배열에는 입력 받은 수식을 '-' 기호를 기준으로 나눠서 저장
		String[] subtraction = br.readLine().split("-");

		for (int i = 0; i < subtraction.length; i++) {
			int temp = 0;
			// 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
			String[] addition = subtraction[i].split("\\+");

			// 덧셈으로 나뉜 토큰들을 모두 더한다.
			for (int j = 0; j < addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			// 첫 번째토큰인 경우 temp값이 첫 번째 수가 된다.
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
}
