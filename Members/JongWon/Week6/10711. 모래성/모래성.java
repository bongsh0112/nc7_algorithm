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
    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());
    String[][] map = new String[H][W];

    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < H; i++) {
      map[i] = br.readLine().split("");
      for (int j = 0; j < W; j++)
        if (map[i][j].equals("."))
          q.offer(new int[] { i, j });
    }

    int answer = 0;

    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        int[] current = q.poll();
        for (int j = 0; j < dx.length; j++) {
          int tx = dx[j] + current[0];
          int ty = dy[j] + current[1];
          if (tx < 0 || ty < 0 || tx >= H || ty >= W)
            continue;
          if (map[tx][ty].equals("."))
            continue;

          int val = Integer.valueOf(map[tx][ty]) - 1;
          if (val == 0) {
            q.offer(new int[] { tx, ty });
            map[tx][ty] = ".";
          } else {
            map[tx][ty] = String.valueOf(val);
          }
        }
      }
      if (!q.isEmpty())
        answer++;
    }

    System.out.println(answer);
  }
}
