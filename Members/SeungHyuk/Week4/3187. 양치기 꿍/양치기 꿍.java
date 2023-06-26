import java.util.*;
import java.io.*;
// 양치기 꿍
public class Main {
  static int r, c;
  static char[][] map;
  static boolean[][] visited;
  static final int[] dy = { 0, -1, 0, +1 };
  static final int[] dx = { -1, 0, +1, 0 };
  static int sheep, wolf;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    map = new char[r][c];

    for (int i = 0; i < r; i++) {
      String str= br.readLine();
      for (int j = 0; j < c; j++) {
        map[i][j] = str.charAt(j);
      }
    }

    visited = new boolean[r][c];
    
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (!visited[i][j] && map[i][j] != '#') {
          bfs(i, j);
        }
      }
    }

    System.out.println(sheep + " " + wolf);
  }

  static void bfs(int y, int x) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {y, x});
    visited[y][x] = true;

    int wolfcnt = 0;
    int sheepcnt = 0;

    while (!q.isEmpty()) {
      int cur[] = q.poll();
      int cy = cur[0];
      int cx = cur[1];

      if (map[cy][cx] == 'v') {
        wolfcnt++;
      } else if (map[cy][cx] == 'k') {
        sheepcnt++;
      }
      for (int dir = 0; dir < 4; dir++) {
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];

        if (ny < 0 || nx < 0 || ny >= r || nx >= c)
          continue;
        if (visited[ny][nx] || map[ny][nx] == '#')
          continue;

        visited[ny][nx] = true;
        q.offer(new int[] {ny, nx});
      }

    }

    if (sheepcnt > wolfcnt) {
      sheep += sheepcnt;
    } else {
      wolf += wolfcnt;
    }

  }

}
