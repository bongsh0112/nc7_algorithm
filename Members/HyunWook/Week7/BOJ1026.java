
// 1026 - 보물
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);

		int S = 0;
		for (int i = 0; i < N; i++) {
			// A[i]는 A 배열의 현재 위치의 원소를 의미합니다.
			// B[N - 1 - i]는 B 배열의 현재 위치의 원소를 의미합니다.
			// 여기서 N - 1 - i는 B 배열을 역순으로 접근하기 위한 인덱스입니다.
			// 즉, B 배열의 마지막 원소부터 시작하여 앞으로 이동하면서 값을 가져옵니다.
			S += A[i] * B[N - 1 - i];
		}
		// 이렇게 함으로써 A와 B 배열의 원소를 각각 서로 반대 순서로 곱하여 S에 누적하게 됩니다.
		// 이는 주어진 문제에서 S의 값을 최소로 만들기 위한 방법 중 하나입니다.
		// 배열을 오름차순으로 정렬한 후, A 배열은 앞에서부터,
		// B 배열은 뒤에서부터 순서대로 원소를 가져와서 곱하면 작은 값을 더하게 되어S의 최솟값을 구할 수 있습니다.
		System.out.println(S);
	}
}

// 예제 1:

// 주어진 입력에 따라 A 배열은 {1, 1, 1, 6, 0}, B 배열은 {2, 7, 8, 3, 1}입니다.
// A 배열을 오름차순으로 정렬하면 {0, 1, 1, 1, 6}, B 배열을 정렬하면 {1, 2, 3, 7, 8}이 됩니다.
// S의 초기값은 0입니다.
// 반복문을 통해 A 배열의 첫 번째 원소부터 마지막 원소까지 순회하면서 S += A[i] * B[N - 1 - i]을 수행합니다.
// i=0일 때, S = S + A[0] * B[5 - 1 - 0] = 0 + 0 * 8 = 0
// i=1일 때, S = S + A[1] * B[5 - 1 - 1] = 0 + 1 * 7 = 7
// i=2일 때, S = S + A[2] * B[5 - 1 - 2] = 7 + 1 * 3 = 10
// i=3일 때, S = S + A[3] * B[5 - 1 - 3] = 10 + 1 * 2 = 12
// i=4일 때, S = S + A[4] * B[5 - 1 - 4] = 12 + 6 * 1 = 18
// 반복문이 종료되고, S의 최종값인 18을 출력합니다.