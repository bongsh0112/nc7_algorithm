// 1012 유기농배추 - BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

public class Main {
  static int M, N, K;
  static int graph[][] = new int[50][50];
  static int[] dx = { 0, -1, 0, 1 };
  static int[] dy = { 1, 0, -1, 0 };

  public static void bfs(int x, int y) {
    Queue<Point> que = new LinkedList<>();
    que.offer(new Point(x, y));
    graph[x][y] = 0;

    while (!que.isEmpty()) {
      Point p = que.poll();

      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];

        if (nx >= 0 && nx < M && ny >= 0 && ny < N && graph[nx][ny] == 1) {
          graph[nx][ny] = 0;
          que.offer(new Point(nx, ny));
        }
      }
    }
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

      // M x N 크기의 배추 지도를 탐색하면서 배추가 있는 위치를 찾습니다.
      // 배추가 있는 위치일 경우 BFS를 호출하여 해당 배추와 연결된 모든 배추를 방문 처리
      // BFS가 호출된 횟수가 유기농 배추 영역의 개수를 의미하므로, 이 값을 cnt에 누적
      int cnt = 0;
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (graph[i][j] == 1) {
            bfs(i, j);
            cnt += 1;
          }
        }
      }

      System.out.println(cnt);

    }
  }
}

// https://141227.tistory.com/230 : 참조(정리잘됌)
