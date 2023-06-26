// 4963 섬의개수 - DFS

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  // 상,하,좌,우 대각선
  static int[] x = { -1, 1, 0, 0, 1, -1, 1, -1 };
  static int[] y = { 0, 0, -1, 1, 1, -1, -1, 1 };
  static int w; // 너비
  static int h; // 높이
  // 지도의 크기에 맞게 map 배열과 visited 배열을 초기화합니다.
  static int[][] map;
  static boolean[][] visited;
  static int count;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      // 각 줄에는 w개의 숫자가 주어지며, 1은 땅을 나타내고 0은 바다를 나타냅니다
      String[] wh = br.readLine().split(" ");
      w = Integer.parseInt(wh[0]);
      h = Integer.parseInt(wh[1]);

      if (w == 0 && h == 0) {
        break;
      }

      // 입력받은 값을 map 배열에 저장
      map = new int[h][w];
      visited = new boolean[h][w];

      // 이중 반복문을 사용하여 지도의 모든 위치를 탐색합니다.
      for (int i = 0; i < h; i++) {
        String[] str = br.readLine().split(" ");
        for (int j = 0; j < w; j++) {
          map[i][j] = Integer.parseInt(str[j]);
        }
      }
      count = 0;

      // 만약 현재 위치가 땅(1)이고 아직 방문하지 않았다면(!visited[i][j]), dfs 함수를 호출하여 해당 섬을 탐색합니다.
      // dfs 함수가 호출되었을 때, 섬의 개수를 세기 위해 count를 1 증가시킵니다.
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (map[i][j] == 1 && !visited[i][j]) {
            dfs(i, j);
            count++;
          }
        }
      }

      System.out.println(count);
    }
  }

  // dfs 함수는 재귀적으로 호출되며, 각 땅을 방문하고 인접한 땅을 찾아 탐색합니다.
  static void dfs(int a, int b) {
    // dfs 함수에서는 현재 위치(a, b)를 방문했음을 표시하기 위해 visited[a][b]를 true로 설정합니다.
    visited[a][b] = true;

    for (int i = 0; i < 8; i++) {
      // 상, 하, 좌, 우, 대각선 방향으로 이동하며 인접한 땅을 찾습니다.
      // 인접한 땅이 지도 내에 있고, 해당 땅을 방문하지 않았으며
      // (map[a + x[i]][b + y[i]] == 1 && !visited[a + x[i]][b + y[i]]),
      // 해당 땅이 땅(1)인 경우에 dfs 함수를 재귀적으로 호출합니다.
      if (a + x[i] >= 0 && a + x[i] < h && b + y[i] >= 0 && b + y[i] < w
          && map[a + x[i]][b + y[i]] == 1
          && !visited[a + x[i]][b + y[i]]) {
        dfs(a + x[i], b + y[i]);
      }
    }
  }

}