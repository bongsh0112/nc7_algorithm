// 2875 - 대회 or 인턴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 여학생 수
		int M = Integer.parseInt(st.nextToken()); // 남학생 수
		int K = Integer.parseInt(st.nextToken()); // 인턴쉽에 참여해야하는 학생의 수

		int cnt = 0;
		while (N >= 2 && M >= 1 && M + N >= 3 + K) {
			N -= 2;
			M -= 1;
			cnt++;
		}
		System.out.println(cnt);

	}
}
