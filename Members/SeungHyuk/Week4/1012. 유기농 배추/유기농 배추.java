import java.io.*;
import java.util.StringTokenizer;
// 유기농 배추
public class Main {
  static int tc, N, M;
  static int[][] visited;
  static int[][] map;
  static final int[] dy = { -1, 0, +1, 0 };
  static final int[] dx = { 0, +1, 0, -1 };
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    tc = Integer.parseInt(br.readLine());

    for (int i = 0; i < tc; i++) {
      input();
      int cnt = 0;

      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
          if (map[j][k] == 1 && visited[j][k] == 0) {
            dfs(j, k);
            cnt++;
          }
        }
      }

      sb.append("" + cnt + "\n");
    }

    System.out.println(sb);
  }
  
  public static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    map = new int[N][M];
    visited = new int[N][M];
    
    for (int i = 0; i < K; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st2.nextToken());
      int y = Integer.parseInt(st2.nextToken());
      map[y][x] = 1;
    }
  }

  static void dfs(int y, int x) {
    if (y < 0 || x < 0 || y >= N || x >= M)
      return;
    if (map[y][x] == 1 && visited[y][x] == 0) {
      visited[y][x] = 1;
      for (int i = 0; i < 4; i++) {
        dfs(y+dy[i], x+dx[i]);
      }
    }    

  }

}
