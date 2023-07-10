import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int N, M;

  public static void main(String[] args) throws Exception {
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    int[][] map = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(line[j - 1]);
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        map[i][j] = map[i][j] + map[i][j - 1];
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      String[] order = br.readLine().split(" ");
      int sx = Integer.parseInt(order[0]);
      int sy = Integer.parseInt(order[1]) - 1;
      int ex = Integer.parseInt(order[2]);
      int ey = Integer.parseInt(order[3]);

      int minus = 0;
      int sum = 0;
      for (int x = sx; x <= ex; x++) {
        sum += map[x][ey];
        minus += map[x][sy];
      }
      sb.append((sum - minus) + "\n");
    }
    System.out.println(sb);
  }
}
