import java.io.*;
// 섬의 개수
public class Main {
  static int x, y;
  static int[][] map;
  static boolean [][] visited;
  static final int[] dy = { -1, -1, 0, +1, +1, +1, 0, -1 };
  static final int[] dx = { 0, +1, +1, +1, 0, -1, -1, -1 };
  static int cy, cx;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    while (true) {
      String[] str = br.readLine().split(" ");
      x = Integer.parseInt(str[0]);
      y = Integer.parseInt(str[1]);
      if (x == 0 && y == 0) break;
      
      map = new int[y+1][x+1];
      visited = new boolean[y+1][x+1];

      for (int i = 0; i < y; i++) {
        String[] str2 = br.readLine().split(" ");
        for (int j = 0; j < x; j++) {
          map[i][j] = Integer.parseInt(str2[j]);
        }
      }

      int count = 0;
      for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
          if (map[i][j] == 1 && !visited[i][j]) {
            count++;
            dfs(i, j);
          }
        }
      }
        
      sb.append("" + count + "\n");
    }

    System.out.println(sb);
  }

  static void dfs (int i, int j) {
    visited[i][j] = true;

    for (int dir = 0; dir < 8; dir++) {
      cy = i + dy[dir];
      cx = j + dx[dir];

      if (cy >= 0 && cx >= 0 && cy < y && cx < x) {
        if (map[cy][cx] == 1 && !visited[cy][cx]) {
          dfs(cy, cx);
        }
      }
        
    }
  }
    
}
