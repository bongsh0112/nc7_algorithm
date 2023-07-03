import java.util.*;
import java.io.*;
// 토마토!
public class Main {
  static int M, N;
  static int[][] map;
  static final int[] dx = { -1, 0, +1, 0 };
  static final int[] dy = { 0, +1, 0, -1 };
  static Queue<int[]> q;

  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    
    map = new int[N][M];
    q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          q.add(new int[]{i, j});
        }
      }
    }
    System.out.println(bfs());

  }

  static int bfs () {

    while(!q.isEmpty()) {
      int cur[] = q.poll();
      int cy = cur[0];
      int cx = cur[1];

      for (int dir = 0; dir < 4; dir++) {
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];

        if (ny < 0 || nx < 0 || ny >= N || nx >= M)
          continue;
        if (map[ny][nx] == 0) {
          q.add(new int[] {ny, nx});
          map[ny][nx] = map[cy][cx] + 1;
        }
      }  
    }
    int max = Integer.MIN_VALUE;
  
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map [i][j] == 0)
          return -1;
        max = Math.max(max, map[i][j]);
      }
    }
    if (max == 1) 
      return 0;
    else 
      return max -1;
  }

}
