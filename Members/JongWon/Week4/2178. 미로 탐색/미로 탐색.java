import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int N, M;

  // 지도, 방문 저장 변수
  private static String[][] map;
  private static int[][] dist;

  private static int[] dx = { 1, 0, -1, 0 };
  private static int[] dy = { 0, 1, 0, -1 };

  public static void main(String[] args) throws Exception {
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    map = new String[N][M];
    dist = new int[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().split("");
      Arrays.fill(dist[i], -1);
    }

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { 0, 0 });
    dist[0][0] = 1;

    while (!q.isEmpty()) {
      int[] n = q.poll();

      for (int i = 0; i < dx.length; i++) {
        int tx = n[0] + dx[i];
        int ty = n[1] + dy[i];

        if (tx < 0 || tx >= N || ty < 0 || ty >= M) {
          continue;
        }
        if (dist[tx][ty] != -1 || !"1".equals(map[tx][ty])) {
          continue;
        }

        dist[tx][ty] = dist[n[0]][n[1]] + 1;
        q.add(new int[] { tx, ty });
      }
    }
    System.out.println(dist[N - 1][M - 1]);
  }
}