import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int N, M, K;
  private static int[][] nums;

  public static void main(String[] args) throws Exception {
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    nums = new int[N][M];
    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        nums[i][j] = Integer.parseInt(line[j]);
      }
    }

    StringBuffer sb = new StringBuffer();

    K = Integer.parseInt(br.readLine());
    for (int t = 0; t < K; t++) {
      int num = 0;
      String[] line = br.readLine().split(" ");
      int ti = Integer.parseInt(line[0]) - 1;
      int tj = Integer.parseInt(line[1]) - 1;
      int tx = Integer.parseInt(line[2]) - 1;
      int ty = Integer.parseInt(line[3]) - 1;

      for (int i = ti; i <= tx; i++) {
        for (int j = tj; j <= ty; j++) {
          num += nums[i][j];
        }
      }
      sb.append(num + "\n");
    }
    System.out.print(sb);
  }
}
