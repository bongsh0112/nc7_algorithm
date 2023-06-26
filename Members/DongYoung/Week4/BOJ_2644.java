package Members.DongYoung.Week4;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_2644 {
  static int[] lengths;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = Integer.parseInt(scanner.nextLine());

    String inputStr = scanner.nextLine();

    int v = Integer.parseInt(inputStr.split(" ")[0]);
    int target = Integer.parseInt(inputStr.split(" ")[1]);

    int M = Integer.parseInt(scanner.nextLine());

    int[][] adjArr = new int[N + 1][N + 1];

    for (int i = 0; i < M; i++) {
      inputStr = scanner.nextLine();
      int a1 = Integer.parseInt(inputStr.split(" ")[0]);
      int a2 = Integer.parseInt(inputStr.split(" ")[1]);
      adjArr[a1][a2] = 1;
      adjArr[a2][a1] = 1;
    }
    boolean[] visited = new boolean[N + 1];
    lengths = new int[N + 1];

    bfs(v, adjArr, visited);
    if (lengths[target] == 0) {
      System.out.println(-1);
    } else {
      System.out.println(lengths[target]);
    }

  }

  static void bfs(int v, int[][] adjArr, boolean[] visited) {
    Queue<a> queue = new LinkedList<>();
    queue.offer(new a(v, 0));
    visited[v] = true;

    while (!queue.isEmpty()) {
      a aa = queue.poll();
      int len = aa.length;
      len = len + 1;
      v = aa.x;
      for (int i = 1; i <= adjArr.length - 1; i++) {
        if (adjArr[v][i] == 1 && !visited[i]) {
          queue.offer(new a(i, len));
          visited[i] = true;
          lengths[i] = len;
        }
      }
    }

  }

  static public class a {
    public int x = 0;
    public int length = 0;

    public a(int x1, int len) {
      x = x1;
      length = len;
    }
  }
}
