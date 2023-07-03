import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int N, M;

  public static void main(String[] args) throws Exception {
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);
    int[] arr = new int[N + 1];
    int[] sumArr = new int[N + 1];

    String[] line = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(line[i - 1]);
    }

    for (int i = 1; i <= N; i++) {
      sumArr[i] = sumArr[i - 1] + arr[i];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      String[] lr = br.readLine().split(" ");
      int l = Integer.parseInt(lr[0]) - 1;
      int r = Integer.parseInt(lr[1]);

      sb.append(sumArr[r] - sumArr[l] + "\n");
    }
    System.out.println(sb);
  }
}