package Members.DongYoung.Week5;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576 {

  static int[][] adjArr;
  static int[][] map;
  static int[] dx = { 0, 1, 0, -1 };
  static int[] dy = { -1, 0, 1, 0 };
  static boolean[][] visited;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    final int H = Integer.parseInt(str.split(" ")[1]);
    final int W = Integer.parseInt(str.split(" ")[0]);

    adjArr = new int[H + 1][W + 1];
    map = new int[H + 1][W + 1];
    visited = new boolean[H + 1][W + 1];

    for (int i = 1; i <= H; i++) {
      str = scanner.nextLine();
      String[] splitList = str.split(" ");
      for (int j = 1; j <= W; j++) {
        if (splitList[j - 1].equals("-1")) {
          adjArr[i][j] = -1;
          map[i][j] = -1;
        } else {
          adjArr[i][j] = Integer.parseInt(splitList[j - 1]);
          map[i][j] = Integer.parseInt(splitList[j - 1]);
        }

      }
    }

    System.out.println(bfs(H, W));
    // 확인
  }

  static int bfs(int H, int W) {
    // 1인 지점들 확인
    int max = 0;
    Queue<xy> queue = new LinkedList<>();
    for (int i = 1; i <= H; i++) {
      for (int j = 1; j <= W; j++) {
        if (adjArr[i][j] == 1) {
          queue.offer(new xy(i, j, 0));
          visited[i][j] = true;
        } else if (adjArr[i][j] == -1) {
          visited[i][j] = true;
        }
      }
    }
    while (!queue.isEmpty()) {
      xy now = queue.poll();
      map[now.y][now.x] = now.length;
      max = now.length;
      int len = now.length + 1;

      for (int i = 0; i < 4; i++) {
        int x1 = now.x + dx[i];
        int y1 = now.y + dy[i];
        if (x1 > 0 && x1 <= W && y1 > 0 && y1 <= H) {
          if (!visited[y1][x1] && adjArr[y1][x1] != -1) {
            queue.offer(new xy(y1, x1, len));
            visited[y1][x1] = true;
          }
        }
      }
    }
    for (int i = 1; i <= H; i++) {
      for (int j = 1; j <= W; j++) {
        if (!visited[i][j]) {
          return -1;
        }
      }
    }

    return max;
  }

  static class xy {
    int x;
    int y;
    int length;

    public xy(int y, int x, int length) {
      this.x = x;
      this.y = y;
      this.length = length;
    }
  }
}
