import java.io.*;
import java.util.*;
// 아기 상어2
public class Main {
  static int N, M;
  static int[][] map;
  static int[][] check;
  static int[] dx = { 0, +1, +1, +1, 0, -1, -1, -1 };
  static int[] dy = { -1, -1, 0, +1, +1, +1, 0, -1 };

  static Queue<int[]> q;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    check = new int[N][M];
    q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          q.add(new int[] {i, j});
        }
      }
    }
    System.out.println(bfs());
  }

  static int bfs() {
    int answer = Integer.MIN_VALUE;
    while (!q.isEmpty()) {
      int cur[] = q.poll();
      int cy = cur[0];
      int cx = cur[1];

      for (int dir = 0; dir < 8; dir++) {
        int ny = cy + dy[dir]; 
        int nx = cx + dx[dir];
        if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
        if (check[ny][nx] != 0 || map[ny][nx] == 1) continue;

        // 최단거리 업데이트
        check[ny][nx] = check[cy][cx] + 1;
        if (check[ny][nx] > answer) 
          answer = check[ny][nx];
           
        q.add(new int[] {ny, nx});
      }
    }
    return answer;
  }
}