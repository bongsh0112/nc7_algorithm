import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, Q, M;
	/** 전체 학생 수
	 * 졸고 있는 학생 수
	 * 출석 코드를 보낼 학생 수
	 * 구간의 수
	 */
	static int[] badStudents;
	static int[] codeStudents;
	static boolean[] received;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer stringBuffer = new StringBuffer();
		
		String[] str = bufferedReader.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		Q = Integer.parseInt(str[2]);
		M = Integer.parseInt(str[3]);
		
		received = new boolean[5003]; // 앞 3개는 안쓴다.
		
		badStudents = new int[K];
		str = bufferedReader.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			badStudents[i] = Integer.parseInt(str[i]);
		}
		
		codeStudents = new int[Q];
		str = bufferedReader.readLine().split(" ");
		for (int i = 0; i < Q; i++) {
			codeStudents[i] = Integer.parseInt(str[i]);
		}
		
		for (int i = 0; i < Q; i++) {
			if (isSleep(codeStudents[i])) { // 코드를 처음으로 받은 학생이 잔다면 received 체크하지 않는다
				continue;
			}
			if (!received[codeStudents[i]]) { // 하나의 코드에 대해 그것을 처음으로 받은 학생이 received가 아니므로 체크해주어야 한다.
				for (int j = codeStudents[i]; j < N + 3; j++) { // 전체 학생 검사는 여기서
					if (j % codeStudents[i] == 0) { // 전체 학생 중 코드를 처음 받은 학생의 번호의 배수인 학생이라면
						if (!isSleep(j)) { // 근데 이 학생이 자고있지 않으면?
							received[j] = true; // 출석체크 완료
						}
					}
				}
			}
		}
		
		int[] cumSum = new int[N + 3];
		for (int i = 3; i < cumSum.length; i++) {
			cumSum[i] = cumSum[i - 1] + ((!received[i]) ? 1 : 0);
		}
		for (int i = 0; i < M; i++) {
			str = bufferedReader.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			System.out.println(cumSum[end] - cumSum[start - 1]);
		}
	}
	
	static boolean isSleep(int num) {
		for (int i = 0; i < K; i++) {
			if (num == badStudents[i]) {
				return true;
			}
		}
		return false;
	}
	
}