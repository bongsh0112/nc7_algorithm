// 11659 구간 합 구하기4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // n은 배열의 크기를 나타내는 변수입니다.
    int m = Integer.parseInt(st.nextToken()); // m은 구간 합을 계산할 횟수를 나타내는 변수입니다

    int num[] = new int[n]; // num은 입력받은 수열을 저장하는 배열입니다.
    int sum[] = new int[n + 1]; // sum은 부분 합을 저장하는 배열로, n + 1 크기로 초기화합니다.

    st = new StringTokenizer(br.readLine()); // st에 입력받은 수열을 공백을 기준으로 분리하여 저장합니다.
    for (int i = 0; i < n; i++) { // n번 반복하면서 num 배열에 입력받은 수열의 값을 저장합니다.
      num[i] = Integer.parseInt(st.nextToken());
    }
    sum[1] = num[0]; // sum[1]에는 num[0] 값을 저장합니다.
    // 2부터 n + 1까지 반복하면서 sum[i]를 sum[i - 1]과 num[i - 1]의 합으로 계산하여 저장합니다.
    for (int i = 2; i < n + 1; i++) { //
      sum[i] = sum[i - 1] + num[i - 1];
    }
    for (int i = 0; i < m; i++) { // m번 반복하면서 구간의 시작과 끝 인덱스를 입력받고, s와 e 변수에 저장합니다.
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      System.out.println(sum[e] - sum[s - 1]); // sum[e] - sum[s - 1]을 계산하여 구간 합을 출력합니다.
      // 구간 합을 계산할 때, sum[e]에서 sum[s - 1]을 빼는 이유는
      // sum 배열에서 s 인덱스 이전의 항목들의 합을 미리 계산해두었기 때문입니다
    }
  }
}
