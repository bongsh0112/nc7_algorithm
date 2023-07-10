import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10986
public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int N, M;

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    long[] ary = new long[N + 1];
    long[] modAry = new long[M + 1];

    long cnt = 0;
    for (int i = 1; i <= N; i++) {
      ary[i] = ary[i - 1] + Long.parseLong(st.nextToken());
      int mod = (int) (ary[i] % M);
      if (mod == 0) {
        cnt++;
      }
      modAry[mod]++; // 모듈러 연산을 위해 필요하다.
    }

    // 모듈러연산. 근데 잘모르겠슴
    for (int i = 0; i < M; i++) {
      if (modAry[i] > 1)
        cnt = (cnt + (modAry[i] * (modAry[i] - 1) / 2));
    }
    System.out.println(cnt);
  }
}
