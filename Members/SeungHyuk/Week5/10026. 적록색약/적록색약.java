import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 적록색약
public class Main {
  static int N;
  static char[][] map;
  static boolean[][] visited;
  static final int[] dy = { -1, 0, +1, 0 };
  static final int[] dx = { 0, +1, 0, -1 };
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = str.charAt(j);  
      }
    }

    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          dfs(i,j);
          cnt++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(cnt);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 'G') {
          map[i][j] = 'R';
        }
      }
    }

    cnt = 0;
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          dfs(i,j);
          cnt++;
        }
      }
    }
    sb.append(" " + cnt);
    
    System.out.println(sb.toString());
  }
  
  static void dfs(int y, int x) {
    visited[y][x] = true;
    char cur = map[y][x];
    for (int dir = 0; dir < 4; dir++) {
      int ny = y + dy[dir];
      int nx = x + dx[dir];

      if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
      if (!visited[ny][nx] && map[ny][nx] == cur)
        dfs(ny, nx);
    }
  }
}
