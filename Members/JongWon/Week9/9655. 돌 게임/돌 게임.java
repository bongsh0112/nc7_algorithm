import java.io.BufferedReader;
import java.io.InputStreamReader;

//1더하기, 3곱하기, 2곱하기
public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  // 1개와 3개
  // 최소갯수를 배열로 셈, 홀수 짝수을 하기 위한 횟수로, 홀수는 상근이, 짝수는 창영이가 승리한다
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] ary = new int[N + 1];
    ary[1] = 1;
    if (N > 3)
      ary[3] = 1;
    for (int i = 1; i <= N; i++) {
      if (i + 1 <= N)
        ary[i + 1] = ary[i + 1] == 0 ? ary[i] + 1 : Math.min(ary[i] + 1, ary[i + 1]);
      if (i + 3 <= N)
        ary[i + 3] = ary[i + 3] == 0 ? ary[i] + 1 : Math.min(ary[i] + 1, ary[i + 3]);
    }
    System.out.println(ary[N] % 2 == 0 ? "CY" : "SK");
  }
}
