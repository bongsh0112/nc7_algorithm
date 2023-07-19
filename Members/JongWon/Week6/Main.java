//Week5 Main Template
package Members.JongWon.Week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        int num = Integer.parseInt(st.nextToken());
        map[i][j] = num + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
      }
    }

    int max = Integer.MIN_VALUE;
    for (int x = 1; x <= N; x++) {
      for (int y = 1; y <= M; y++) {
        for (int tx = 0; tx < x; tx++) {
          for (int ty = 0; ty < y; ty++) {
            int num = map[x][y] - map[tx][y] - map[x][ty] + map[tx][ty];
            max = Math.max(max, num);
          }
        }
      }
    }
    System.out.println(max);

  }
}
