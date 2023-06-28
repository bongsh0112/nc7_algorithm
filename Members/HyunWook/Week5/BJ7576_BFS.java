// 7576 토마토 - BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int M, N, count;
  static int[][] map;
  static Queue<int[]> que;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken()); // 토마토상자의 가로
    N = Integer.parseInt(st.nextToken()); // 토마토상자의 세로
    map = new int[N][M]; // 토마토 상자의 현재 상태

    // 각 칸은 토마토의 상태를 나타내며, 0은 익지 않은 토마토, 1은 익은 토마토, -1은 토마토가 들어있지 않은 칸을 의미합니다.
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    que = new LinkedList<>(); // 익은 토마토의 좌표를 저장
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 1)
          que.add(new int[] { i, j });
      }
    }
    bfs();
  }

  // BFS를 통해 토마토가 익는데 걸리는 최소 일수를 계산합니다.
  static void bfs() {

    // que가 비어질 때까지 다음 과정을 반복합니다:
    // 큐에서 좌표를 하나 꺼내고, 해당 위치의 상하좌우를 확인하여 익지 않은 토마토(0)인 경우 익은 토마토로 변경하고 큐에 추가합니다.
    // 이때, 익은 토마토의 상태값을 현재 위치의 상태값 + 1로 갱신합니다. 이는 토마토가 익는데 걸린 일수를 나타냅니다.
    while (!que.isEmpty()) {
      int now[] = que.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
          if (map[nx][ny] == 0) {
            map[nx][ny] = map[x][y] + 1;
            que.add(new int[] { nx, ny });
          }
        }
      }
    }
    count = 0;

    // 모든 BFS 과정이 끝나면 익지 않은 토마토(0)가 남아있는지 확인하고, 익은 토마토들 중 가장 오래 걸린 일수를 계산합니다.
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          System.out.println(-1);
          return;
        }
        count = Math.max(count, map[i][j]);
      }
    }
    // 최종적으로 걸린 일수에서 1을 뺀 값을 출력합니다.
    // 이는 처음 익은 토마토(1)는 0일에 익었으므로, 일수 계산에서 제외하기 위함입니다
    System.out.println(count - 1);
  }
}
