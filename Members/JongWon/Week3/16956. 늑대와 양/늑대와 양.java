import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
  private static LinkedList<int[]> wolfList = new LinkedList<>();
  private static int R, C;
  private static String[][] map;
  static boolean isSafe = true;

  private static int[] dx = { -1, 1, 0, 0 };
  private static int[] dy = { 0, 0, -1, 1 };

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String[] RC = br.readLine().split(" ");
    R = Integer.parseInt(RC[0]);
    C = Integer.parseInt(RC[1]);
    map = new String[R][C];

    for (int i = 0; i < R; i++) {
      map[i] = br.readLine().split("");
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j].equals("W")) {
          wolfList.add(new int[] { i, j });
        }
      }
    }
    bfs_run();
    if (!isSafe) {
      System.out.println(0);
      return;
    }

    System.out.println(1);
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }

  private static void bfs_run() {
    while (wolfList.size() > 0) {
      int[] wolfxy = wolfList.poll();
      int y = wolfxy[0];
      int x = wolfxy[1];

      for (int i = 0; i < dx.length; i++) {
        int ty = y + dy[i];
        int tx = x + dx[i];
        if (tx >= 0 && ty >= 0 && tx < C && ty < R) {
          if (map[ty][tx].equals(".")) {
            map[ty][tx] = "D";
          }
          if (map[ty][tx].equals("S")) {
            isSafe = false;
            return;
          }
        }
      }
    }
  }
}
