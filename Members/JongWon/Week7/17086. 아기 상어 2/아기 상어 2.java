import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
  private static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < M; j++) {
        int num = Integer.parseInt(st.nextToken());
        map[i][j] = num == 0 ? -1 : 0; // 상어를 0, 기본값 -1

        // 상어인 경우 미리 추가
        if (num == 1)
          q.add(new int[] { i, j });
      }
    }
    int max = Integer.MIN_VALUE;
    while (!q.isEmpty()) {
      int[] current = q.poll();
      for (int i = 0; i < 8; i++) {
        int tx = current[0] + dx[i];
        int ty = current[1] + dy[i];
        if (tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
        if (map[tx][ty] != -1) continue;
        q.add(new int[] { tx, ty });
        map[tx][ty] = map[current[0]][current[1]] + 1;
        max = Math.max(max, map[tx][ty]);
      }
    }
    System.out.println(max);
  }
}
