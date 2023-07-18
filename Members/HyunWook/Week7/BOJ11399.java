
// 11399 - ATM
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 사람의 수
		int[] P = new int[N]; // 각 사람이 돈을 인출하는데 걸리는 시간을 N의 크기만큼 배열로 나타냄

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P); // 돈을 인출하는 시간을 오름차순으로 정렬

		int total = 0; // 각 사람이 돈을 인출하는데 필요한 시간의 합
		int sum = 0; // 누적 시간

		for (int i = 0; i < N; i++) {
			sum += P[i]; // 누적 시간 계산
			total += sum; // 각 사람이 돈을 인출하는데 필요한 시간의 합 갱신
		}
		System.out.println(total);

	}
}

// 예제
// 먼저, P 배열을 오름차순으로 정렬합니다. 정렬 후의 P 배열은 [1, 2, 3, 3, 4]가 됩니다.

// 그리고 각 사람이 돈을 인출하는데 필요한 시간의 합을 계산하기 위해 누적 시간을 사용합니다.
// 누적 시간을 0으로 초기화하고, 반복문을 통해 각 사람의 돈 인출 시간을 누적하여 합을 계산합니다.

// 첫 번째 사람은 1분이 소요되므로 누적 시간은 1이 되고, 합은 1이 됩니다.
// 두 번째 사람은 2분이 소요되므로 누적 시간은 1 + 2 = 3이 되고, 합은 1 + 3 = 4가 됩니다.
// 세 번째 사람은 3분이 소요되므로 누적 시간은 3 + 3 = 6이 되고, 합은 4 + 6 = 10이 됩니다.
// 네 번째 사람은 3분이 소요되므로 누적 시간은 6 + 3 = 9가 되고, 합은 10 + 9 = 19가 됩니다.
// 다섯 번째 사람은 4분이 소요되므로 누적 시간은 9 + 4 = 13이 되고, 합은 19 + 13 = 32가 됩니다.

// 따라서, 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값은 32입니다. 이를 출력합니다.
