package Members.DongYoung.Week7;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Math;

public class BOJ_17086 {

  static int[][] adjArr;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
  static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
  static int maxNum = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    scanner.nextLine();
    adjArr = new int[N][M];
    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String[] split = scanner.nextLine().split(" ");
      for (int j = 0; j < M; j++) {
        adjArr[i][j] = Integer.parseInt(split[j]);
        map[i][j] = adjArr[i][j] == 1 ? 0 : 100;
      }
    }
    bfs();
    System.out.println(maxNum);
  }

  static void bfs() {
    Queue<Node> queue = new LinkedList<>();
    int H = adjArr.length;
    int W = adjArr[0].length;
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (adjArr[i][j] == 1) {
          queue.offer(new Node(i, j, 0));
          visited[i][j] = true;
        }
      }
    }
    while (!queue.isEmpty()) {
      Node now = queue.poll();
      int length = now.length + 1;
      for (int i = 0; i < 8; i++) {
        int x1 = now.x + dx[i];
        int y1 = now.y + dy[i];
        if (x1 >= 0 && x1 < W && y1 >= 0 && y1 < H) {
          if (!visited[y1][x1] && map[y1][x1] > length) {
            map[y1][x1] = length;
            maxNum = Math.max(maxNum, length);
            queue.offer(new Node(y1, x1, length));
            visited[y1][x1] = true;
          }
        }
      }
    }
  }

  static class Node {
    int y;
    int x;
    int length;

    public Node(int y, int x, int length) {
      this.y = y;
      this.x = x;
      this.length = length;
    }
  }

}
