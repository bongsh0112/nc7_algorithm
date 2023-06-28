import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int R, C;

  // 지도, 방문 저장 변수
  private static String[][] map;
  private static boolean[][] visited;

  private static int[] dx = { 1, 0, -1, 0 };
  private static int[] dy = { 0, 1, 0, -1 };

  public static void main(String[] args) throws Exception {
    String[] RC = br.readLine().split(" ");
    R = Integer.parseInt(RC[0]);
    C = Integer.parseInt(RC[1]);

    map = new String[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      map[i] = br.readLine().split("");
      Arrays.fill(visited[i], false);
    }
    int totalWolf = 0, totalSheep = 0;

    for (int x = 0; x < R; x++) {
      for (int y = 0; y < C; y++) {
        if (!visited[x][y] && !"#".equals(map[x][y])) {
          int tempWolf = 0;
          int tempSheep = 0;
          Queue<int[]> q = new LinkedList<>();
          q.add(new int[] { x, y });

          while (!q.isEmpty()) {
            int[] now = q.poll();
            visited[now[0]][now[1]] = true;
            if ("v".equals(map[now[0]][now[1]])) {
              tempWolf++;
            } else if ("k".equals(map[now[0]][now[1]])) {
              tempSheep++;
            }

            for (int i = 0; i < dx.length; i++) {
              int tx = now[0] + dx[i];
              int ty = now[1] + dy[i];
              if (tx < 0 || ty < 0 || tx >= R || ty >= C)
                continue;
              if (visited[tx][ty] || "#".equals(map[tx][ty]))
                continue;
              visited[tx][ty] = true;
              q.add(new int[] { tx, ty });
            }
          }
          if (tempSheep > tempWolf) {
            totalSheep += tempSheep;
          } else {
            totalWolf += tempWolf;
          }

        }
      }
    }
    System.out.println(totalSheep + " " + totalWolf);
  }
}