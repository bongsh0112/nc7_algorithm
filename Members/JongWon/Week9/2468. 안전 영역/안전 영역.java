import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] map;

  private static int[] dx = { 1, -1, 0, 0 };
  private static int[] dy = { 0, 0, 1, -1 };

  private static int N;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    boolean[][] visited;
    int max = Integer.MIN_VALUE;
    for (int water = 0; water <= 100; water++) { // water = 물의 높이
      visited = new boolean[N][N];
      int daePiSo = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j] && map[i][j] - water > 0) {
            daePiSo++;
            dfs(i, j, water, visited);
          }
        }
      }
      max = Math.max(max, daePiSo);
    }
    System.out.println(max);
  }

  private static void dfs(int x, int y, int water, boolean[][] visited) {
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int tx = x + dx[i];
      int ty = y + dy[i];
      if (tx < 0 || ty < 0 || tx >= N || ty >= N)
        continue;
      if (visited[tx][ty] || map[tx][ty] - water <= 0)
        continue;
      dfs(tx, ty, water, visited);
    }
  }
}
