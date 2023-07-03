import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int M, N;
  private static int[][] map;
  // 좌표
  private static int[] dx = { -1, 1, 0, 0 };
  private static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws Exception {
    String[] MN = br.readLine().split(" ");
    M = Integer.parseInt(MN[0]); // Y
    N = Integer.parseInt(MN[1]); // X

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(line[j]);
      }
    }

    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 1) {
          q.add(new int[] { i, j });
        }
      }
    }

    while (!q.isEmpty()) {
      int[] current = q.poll();
      for (int i = 0; i < dx.length; i++) {
        int tx = current[0] + dx[i];
        int ty = current[1] + dy[i];

        // 범위 밖
        if (tx < 0 || ty < 0 || tx >= N || ty >= M) {
          continue;
        }
        if (map[tx][ty] != 0)
          continue;

        map[tx][ty] = map[current[0]][current[1]] + 1;
        q.offer(new int[] { tx, ty });
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          System.out.println(-1);
          return;
        } else {
          max = Math.max(max, map[i][j]);
        }
      }
    }

    System.out.println(max - 1);
  }
}
