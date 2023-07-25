package Members.DongYoung.Week8;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuffer;
import java.util.ArrayList;

public class BOJ_11725 {

  static int[][] graph;
  static boolean[] visited;
  static int[] node;
  static ArrayList<Integer> list[];

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    scanner.nextLine();
    node = new int[N];
    visited = new boolean[N];
    list = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 1; i < N; i++) {

      String[] split = scanner.nextLine().split(" ");
      int a = Integer.parseInt(split[0]);
      int b = Integer.parseInt(split[1]);
      list[a - 1].add(b);
      list[b - 1].add(a);
    }

    // bfs(1);
    dfs(1);
    StringBuffer sb = new StringBuffer();
    for (int i = 1; i < node.length; i++) {
      sb.append(node[i] + "\n");
    }
    System.out.println(sb.toString());

  }

  static void dfs(int k) {
    visited[k - 1] = true;
    for (int i : list[k - 1]) {
      if (!visited[i - 1]) {
        node[i - 1] = k;
        dfs(i);
      }
    }
  }

}
