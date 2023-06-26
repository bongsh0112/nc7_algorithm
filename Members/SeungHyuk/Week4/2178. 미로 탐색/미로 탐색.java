import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int[][] map;
  static boolean[][] visited;
  static int[] dy = { -1, 0, +1, 0 };
  static int[] dx = { 0, +1, 0, -1 };

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }

    visited = new boolean[n][m];
    visited[0][0] = true;
    bfs(0, 0);
    System.out.println(map[n-1][m-1]);
  }

  public static void bfs(int y, int x) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {y, x});

    while (!q.isEmpty()) {
      int cur[] = q.poll();
      int cy = cur[0];
      int cx = cur[1];

      for (int dir = 0; dir < 4; dir++) {
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];

        if (ny < 0 || nx < 0 || ny >= n || nx >= m)
          continue;
        if (visited[ny][nx] || map[ny][nx] == 0)
          continue;
        
        q.add(new int[] {ny, nx});
        map[ny][nx] = map[cy][cx] + 1;
        visited[ny][nx] = true;
      }
    }
  }

  
  
}
