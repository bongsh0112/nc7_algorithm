// 21318 피아노체조

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  // mistake는 실수 횟수를 나타내는 변수입니다.
  static int n, m, mistake;
  // arr은 곡의 각 마디의 난이도를 저장하는 배열입니다.
  static int[] arr;
  // sum은 누적된 실수 횟수를 저장하는 배열입니다.
  static int[] sum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // n은 곡의 길이를 나타내는 변수입니다
    n = Integer.parseInt(br.readLine());

    // n + 1 크기로 arr와 sum 배열을 초기화합니다.
    arr = new int[n + 1];
    sum = new int[n + 1];

    // s 배열에 입력받은 문자열을 공백을 기준으로 분리하여 저장합니다.
    String[] s = br.readLine().split(" ");
    // 1부터 n까지 반복하면서 arr[i]에 s[i - 1] 값을 정수로 변환하여 저장합니다.
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(s[i - 1]);
      // 이전 마디의 난이도(arr[i - 1])와 현재 마디의 난이도(arr[i])를 비교
      // 이전 마디의 난이도가 현재 마디의 난이도보다 크다면, 즉 실수가 발생했다면 sum[i]를 sum[i - 1] + 1로 설정합니다.
      // 그렇지 않은 경우에는 실수가 발생하지 않았으므로 sum[i]를 sum[i - 1]로 설정
      if (arr[i - 1] > arr[i]) {
        sum[i] += sum[i - 1] + 1;
      } else {
        sum[i] = sum[i - 1];
      }
    }
    // m은 질문의 개수를 나타내는 변수입니다.
    m = Integer.parseInt(br.readLine());

    // 마지막으로 질문의 개수를 입력받고, 각 질문에 대한 실수 횟수를 계산하여 출력합니다.
    StringBuilder sb = new StringBuilder();
    int start, end;
    // m만큼 반복하면서 질문을 입력받고, start와 end 변수에 각각 첫 번째와 두 번째 입력 값을 저장합니다.
    for (int i = 0; i < m; i++) {
      String[] s1 = br.readLine().split(" ");
      start = Integer.parseInt(s1[0]);
      end = Integer.parseInt(s1[1]);
      // sum[end] - sum[start]를 계산하여 sb에 추가합니다. 이 값은 start부터 end까지의 실수 횟수를 나타냅니다.
      sb.append(sum[end] - sum[start]).append("\n");
      // 실수 횟수를 초기화하기 위해 mistake 변수를 0으로 설정
      mistake = 0;
    }
    // 모든 질문에 대한 실수 횟수를 계산하고 sb에 저장된 결과를 출력
    System.out.println(sb.toString());
  }
}
