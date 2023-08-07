// 2468 안전 영역 - DFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  // 상하좌우 이동을 위한 배열
  private static final int[] dx = { 1, -1, 0, 0 };
  private static final int[] dy = { 0, 0, 1, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int[][] heights = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        heights[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int maxSafeArea = 0;
    for (int rain = 0; rain <= 200; rain++) {
      boolean[][] visited = new boolean[n][n];
      int safeArea = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (!visited[i][j] && heights[i][j] > rain) {
            dfs(heights, rain, visited, i, j);
            safeArea++;
          }
        }
      }
      maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
    sb.append(maxSafeArea);
    System.out.println(sb);

  }

  private static void dfs(int[][] heights, int rain, boolean[][] visited, int x, int y) {
    int n = heights.length;
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || heights[nx][ny] <= rain) {
        continue;
      }
      dfs(heights, rain, visited, nx, ny);
    }
  }
}
