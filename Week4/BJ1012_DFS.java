// 1012 유기농배추 - DFS

import java.util.Scanner;

public class Main {
  public static int M, N, K;
  public static int graph[][] = new int[50][50];

  public static boolean dfs(int x, int y) {
    if (x < 0 || x >= M || y < 0 || y >= N)
      return false;
    if (graph[x][y] == 1) {
      graph[x][y] = 0;
      dfs(x - 1, y); // 상
      dfs(x + 1, y); // 하
      dfs(x, y - 1); // 좌
      dfs(x, y + 1); // 우
      return true;
    }

    return false;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int tc = 0; tc < T; tc++) {
      M = sc.nextInt();
      N = sc.nextInt();
      K = sc.nextInt();

      for (int k = 0; k < K; k++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        graph[x][y] = 1;
      }

      int cnt = 0;
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (dfs(i, j))
            cnt += 1;
        }
      }

      System.out.println(cnt);

    }
  }
}