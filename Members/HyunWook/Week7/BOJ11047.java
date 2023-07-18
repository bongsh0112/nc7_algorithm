
// 11047 - 동전 0
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 동전의 종류 개수
		int K = Integer.parseInt(st.nextToken()); // 동전을 사용한 합의 개수

		// 동전의 종류 배열을 초기화하여 for문을 통해 coins 배열에 담기
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		// 동전 개수의 최솟값을 구하기 위한 식으로 최솟값을 구할 count(필요한 동전의 개수)를 0으로 초기화하고
		// 현재 종류의 동전을 최대한 큰 종류부터 사용하여(역순) 사용한 동전만큼 K에서 빼고 남은 금액 계산
		// i 변수는 N-1부터 0까지 역순으로 값을 가지게 됩니다.
		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			count += K / coins[i];	// K를 현재 동전 가치 coins[i]로 나눈 몫을 count에 더합니다
			K %= coins[i];	// K를 현재 동전 가치 coins[i]로 나눈 나머지를 K에 할당합니다.
			// 동전을 최대한 사용한 후에도 남은 금액이 있다면, 해당 남은 금액을 다음 작은 동전 가치로 처리합니다.
		}

		// count 변수의 값을 문자열로 변환하여 sb에 추가하는 것을 의미합니다. 이는 최종적으로 출력할 결과를 sb에 저장
		sb.append(count);
		// toString() 메소드를 호출하여 StringBuilder 객체를 문자열로 변환한 후에 출력
		System.out.println(sb.toString());
	}
}

// ### StringBuilder를 사용하여 문자열을 조작하고 결과를 저장하는 이유 :
// 문자열 조작 시에 많은 문자열 객체가 생성되는 것을 방지하기 위해서입니다.
// StringBuilder는 내부적으로 문자열을 가변적인 버퍼에 저장하므로 성능적으로 효율적입니다.
