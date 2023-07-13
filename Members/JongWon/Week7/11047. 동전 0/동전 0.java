import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int M = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] coin = new int[N];
    for (int i = 0; i < N; i++) {
      coin[i] = Integer.parseInt(br.readLine());
    }

    for (int i = N - 1; i >= 0; i--) {
      M += (K / coin[i]);
      K = K % coin[i];
    }
    System.out.println(M);
  }
}