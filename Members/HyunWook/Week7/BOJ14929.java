// 14929 귀찮아 (SIB)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // n을 입력받음
    int n = Integer.parseInt(br.readLine());

    // 배열 arr과 배열 sum을 생성하여 누적 합을 저장합니다.
    int[] arr = new int[n + 1];
    int[] sum = new int[n + 1];

    // 숫자들을 입력받아 arr 배열에 저장하고, sum 배열에 각 위치까지의 누적 합을 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      // 숫자들을 입력받아 arr 배열에 저장하고, sum 배열에는 각 위치까지의 누적 합을 계산하여 저장합니다.
      arr[i] = Integer.parseInt(st.nextToken());
      sum[i] = sum[i - 1] + arr[i];
    }
    // ans 변수를 초기화합니다. 이 변수는 최종 결과값을 저장할 변수입니다.
    long ans = 0;
    for (int i = 1; i < n; i++) {
      // getSubSum 메소드를 사용하여 l부터 r까지의 합을 구하고, arr[i]와 곱하여 ans에 더함
      int v = getSubSum(i + 1, n, sum);
      ans += v * arr[i];
    }
    System.out.println(ans);
  }

  // l부터 r까지의 합을 구하는 메소드
  static int getSubSum(int l, int r, int[] sum) {
    return sum[r] - sum[l - 1];
  }
}
