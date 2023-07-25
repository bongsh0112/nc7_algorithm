//Week5 Main Template
package Members.JongWon.Week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + map[i][j];
      }
    }
    for (int[] mapary : map) {
      System.out.println(Arrays.toString(mapary));
    }
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < M; i++) {
      int total = 0;
      String[] line = br.readLine().split(" ");
      int x1 = Integer.parseInt(line[0]);
      int y1 = Integer.parseInt(line[1]);
      int x2 = Integer.parseInt(line[2]);
      int y2 = Integer.parseInt(line[3]);

      total = map[x2][y2] - map[x1 - 1][y2] - map[x2][y1 - 1] + map[x1 - 1][y1 - 1];
      sb.append(total + "\n");
    }
  }
}
