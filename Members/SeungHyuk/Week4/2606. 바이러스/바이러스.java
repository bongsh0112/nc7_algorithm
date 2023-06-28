import java.util.*;
import java.io.*;

// 바이러스
public class Main {
  static int[][] map;
  static boolean[] visited; 
  static int n; 
  static int m;
  static int start;

  public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      m = Integer.parseInt(br.readLine());
      map = new int[n+10][n+10];
      visited = new boolean[n+10];

      for (int i = 0; i < m; i++) {
        String[] str = br.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);

        map[x][y] = map[y][x] = 1;
      }

      dfs(1); 
      int ret = -1;
      for (Boolean b : visited) {
        if (b == true) ret++;
      }

      System.out.println(ret);
  }

  public static void dfs(int i) {
    visited[i] = true;
    for (int j = 1; j <= n; j++) {
       if (map[i][j] == 1 && visited[j] == false) {
        dfs(j);
       }
    }
  }
}
