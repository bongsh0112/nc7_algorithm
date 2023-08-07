import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String[] NMK = br.readLine().split(" ");
    int N = Integer.parseInt(NMK[0]);
    int M = Integer.parseInt(NMK[1]);
    int K = Integer.parseInt(NMK[2]);

    while (K > 0) {
      if (N >= M * 2) {
        N--;
      } else if (M * 2 > N) {
        M--;
      }
      K--;
    }
    int cnt = 0;
    while (N > 1 && M > 0) {
      N -= 2;
      M--;
      cnt++;
    }
    System.out.println(cnt);
  }
}
