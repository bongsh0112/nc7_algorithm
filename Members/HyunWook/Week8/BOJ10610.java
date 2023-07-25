// 10610 - 30

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// N에 대해 가장 큰 30의 배수를 만들기 위한 프로그램입니다.
// 입력으로 주어진 숫자 N은 문자열로 받아들이며, 문자열을 분석하여 30의 배수를 만들 수 있는지 확인하는 방법을 사용합니다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();

		// str을 문자 배열로 변환하고 Arrays.sort()를 사용하여 배열을 오름차순으로 정렬
		char[] arr = str.toCharArray();
		// Arrays.sort()를 사용하여 arr 배열을 오름차순으로 정렬합니다.
		// 이를 통해 입력된 숫자의 각 자릿수를 가장 큰 값으로 만들 수 있습니다.
		Arrays.sort(arr);

		// sum 변수는 입력된 숫자의 각 자릿수를 더한 값을 저장
		int sum = 0;
		// arr 배열을 역순으로 순회합니다. 이는 가장 큰 값을 앞자리로 가져오기 위함
		for (int i = str.length() - 1; i >= 0; i--) {
			int num = arr[i] - '0';
			// 각 자릿수의 합을 sum 변수에 저장합니다.
			// 역순으로 정렬한 arr 배열의 각 자릿수(num)를 가져와서 sum 변수에 더합니다.
			sum += num;
			// sb.append(num)을 통해 num을 StringBuilder인 sb에 추가합니다.
			// 이로써 sb에는 입력된 숫자를 역순으로 만든 결과가 저장
			sb.append(num);
		}
		// sum이 3의 배수가 아니거나, 가장 큰 자릿수가 0이 아닌 경우
		// sb에 추가된 숫자들로 30의 배수를 만들 수 없기 때문에 -1을 출력합니다.
		// arr[0] - '0' != 0은 첫 자릿수가 0인지를 확인하는 조건문
		if (sum % 3 != 0 || arr[0] - '0' != 0) {
			System.out.println(-1);
		} else {
			// sb에는 입력된 숫자를 가장 큰 값부터 역순으로 조합하여 만든 결과
			System.out.println(sb);
		}
	}
}
// ## 예제 해석 ##
// 예제 입력 1:
// 30

// 예제 출력 1:
// 30

// 설명: 주어진 숫자 자체가 30의 배수이기 때문에, 그대로 출력합니다.

// 예제 입력 2:
// 102

// 예제 출력 2:
// 210

// 설명: 입력된 숫자를 오름차순으로 정렬하면 012가 됩니다. 각 자릿수를 역순으로 정렬하여 가장 큰 수인 210을 만들 수 있습니다.

// 예제 입력 3:
// 2931

// 예제 출력 3:
// -1

// 설명: 주어진 숫자로는 30의 배수를 만들 수 없기 때문에 -1을 출력합니다.

// 예제 입력 4:
// 80875542

// 예제 출력 4:
// 88755420

// 설명: 입력된 숫자를 오름차순으로 정렬하면 022455788이 됩니다. 각 자릿수를 역순으로 정렬하여 가장 큰 수인 88755420을 만들
// 수 있습니다.
