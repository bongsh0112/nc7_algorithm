import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int[] dx = { -1, 1, 0, 0 };
  private static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[][] threeColorMap = new int[N][N];
    boolean[][] threeColorVisited = new boolean[N][N];

    int[][] twoColorMap = new int[N][N];
    boolean[][] twoColorVisited = new boolean[N][N];

    // R = 3, G = 2, B = 1
    // R, G = 2, B = 1
    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split("");

      for (int j = 0; j < line.length; j++) {
        if ("R".equals(line[j])) {
          threeColorMap[i][j] = 3;
          twoColorMap[i][j] = 2;
        } else if ("G".equals(line[j])) {
          threeColorMap[i][j] = 2;
          twoColorMap[i][j] = 2;
        } else if ("B".equals(line[j])) {
          threeColorMap[i][j] = 1;
          twoColorMap[i][j] = 1;
        }
      }
    }

    int twoColorCnt = 0;
    int threeColorCnt = 0;

    for (int x = 0; x < N; x++) {
      for (int y = 0; y < N; y++) {
        if (!threeColorVisited[x][y]) {
          threeColorCnt++;
          dfs(x, y, threeColorMap[x][y], threeColorMap, threeColorVisited);
        }

        if (!twoColorVisited[x][y]) {
          twoColorCnt++;
          dfs(x, y, twoColorMap[x][y], twoColorMap, twoColorVisited);
        }
      }
    }

    System.out.println(threeColorCnt + " " + twoColorCnt);
  }

  public static void dfs(int x, int y, int val, int[][] map, boolean[][] visited) {
    visited[x][y] = true;

    for (int i = 0; i < dx.length; i++) {
      int tx = x + dx[i];
      int ty = y + dy[i];

      // 배열 벗어나는 경우
      if (tx < 0 || ty < 0 || tx >= map.length || ty >= map.length) {
        continue;
      }

      // 방문했거나, 같은 값이 아닌경우
      if (visited[tx][ty] || val != map[tx][ty]) {
        continue;
      }
      dfs(tx, ty, val, map, visited);
    }
  }
}
