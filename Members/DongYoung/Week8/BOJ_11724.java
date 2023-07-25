package Members.DongYoung.Week8;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_11724 {

  static int[][] graph;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    scanner.nextLine();

    graph = new int[M][2];
    visited = new boolean[N];
    for (int i = 0; i < M; i++) {
      String[] split = scanner.nextLine().split(" ");
      graph[i][0] = Integer.parseInt(split[0]) - 1;
      graph[i][1] = Integer.parseInt(split[1]) - 1;
    }

    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (bfs(i - 1)) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }

  static boolean bfs(int k) {
    Queue<Integer> queue = new LinkedList<>();
    if (visited[k]) {
      return false;
    }
    queue.offer(k);
    visited[k] = true;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int i = 0; i < graph.length; i++) {
        if (graph[i][0] == now) {
          if (!visited[graph[i][1]]) {
            queue.offer(graph[i][1]);
            visited[graph[i][1]] = true;
          }
        } else if (graph[i][1] == now) {
          if (!visited[graph[i][0]]) {
            queue.offer(graph[i][0]);
            visited[graph[i][0]] = true;
          }

        }
      }
    }

    return true;
  }

}
