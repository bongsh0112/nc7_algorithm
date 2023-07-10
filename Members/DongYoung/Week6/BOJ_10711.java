package Members.DongYoung.Week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class BOJ_10711 {

  static int[][] adjArr;
  static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
  static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
  static int maxNum = 0;

  static public void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] splitStrs = scanner.nextLine().split(" ");
    int N = Integer.parseInt(splitStrs[0]);
    int M = Integer.parseInt(splitStrs[1]);
    adjArr = new int[N + 1][M + 1];
    // System.out.println(N);
    for (int i = 1; i <= N; i++) {
      String str = scanner.nextLine();
      for (int j = 1; j <= M; j++) {
        if (str.substring(j - 1, j).equals(".")) {
          adjArr[i][j] = 0;
        } else {
          adjArr[i][j] = Integer.parseInt(str.substring(j - 1, j));
        }
      }
    }
    bfs(N, M);
    System.out.println(maxNum);
  }

  static void bfs(int H, int W) {
    Queue<Node> queue = new LinkedList<>();

    for (int i = 1; i <= H; i++) {
      for (int j = 1; j <= W; j++) {
        if (adjArr[i][j] == 0) {
          queue.offer(new Node(i, j, 0));
        }
      }
    }
    ArrayList<int[]> xy = new ArrayList<>();
    int tempLen = 0;
    while (!queue.isEmpty()) {
      Node now = queue.poll();
      int length = now.length + 1;
      if (tempLen < now.length) {
        for (int i = 0; i < xy.size(); i++) {
          int x = xy.get(i)[1];
          int y = xy.get(i)[0];
          adjArr[y][x] = 0;
        }
        xy.clear();
        tempLen++;
      }

      maxNum = Math.max(maxNum, now.length);
      for (int i = 0; i < 8; i++) {
        int x1 = now.x + dx[i];
        int y1 = now.y + dy[i];
        if (x1 > 0 && x1 <= W && y1 > 0 && y1 <= H) {
          if (adjArr[y1][x1] != 0) {
            if (adjArr[y1][x1] <= check(y1, x1)) {
              xy.add(new int[] { y1, x1 });
              System.out.println(y1 + " " + x1);
              queue.offer(new Node(y1, x1, length));
            }
          }
        }
      }
    }
  }

  static int check(int y1, int x1) {
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
      int x2 = x1 + dx[i];
      int y2 = y1 + dy[i];
      if (adjArr[y2][x2] == 0) {
        cnt++;
      }
    }
    return cnt;
  }

  static class Node {
    int y;
    int x;
    int length;

    public Node(int y, int x, int length) {
      this.x = x;
      this.y = y;
      this.length = length;
    }
  }
}
