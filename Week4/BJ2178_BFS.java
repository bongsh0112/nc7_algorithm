// 2178 미로탐색 - BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
  static int N, M;
  static int[][] graph = new int[100][100];
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static int bfs(int x, int y) {
    // que는 BFS 탐색을 위한 큐로, Point 객체를 요소로 가집니다.
    Queue<Point> que = new LinkedList<>();
    // 시작점을 큐에 추가합니다
    que.offer(new Point(x, y));

    // 큐가 빌 때까지 아래의 과정을 반복
    while (!que.isEmpty()) {
      // 큐에서 하나의 요소를 꺼내옵니다(que.poll()).
      Point p = que.poll();
      // 꺼낸 요소의 좌표를 (x, y)에 저장
      x = p.x;
      y = p.y;

      // 상, 하, 좌, 우 네 방향을 탐색하면서 유효한 좌표인지 확인
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        // 유효한 좌표이고, 해당 좌표의 값이 1인 경우
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 1) {
          // 해당 좌표의 값을 graph[x][y] + 1로 갱신합니다. 이는 이전 좌표에서 현재 좌표로 이동한 거리를 나타냅니다.
          graph[nx][ny] = graph[x][y] + 1;
          // 해당 좌표를 큐에 추가합니다(que.offer(new Point(nx, ny))).
          que.offer(new Point(nx, ny));
        }
      }
    }
    return graph[N - 1][M - 1];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 첫 번째 줄에서는 N과 M을 입력받습니다.
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        // 다음 N개의 줄에서는 그래프 정보를 입력받아 graph 배열에 저장
        graph[i][j] = str.charAt(j) - '0';
      }
    }
    // bfs(0, 0)를 호출하여 출발점(0, 0)부터 도착점(N-1, M-1)까지의 최단 거리를 계산
    System.out.println(bfs(0, 0));
  }
}

// https://141227.tistory.com/231 : 참조(정리잘됌)

// java.awt.Point 클래스:
// 2차원 평면 상의 한 점을 나타내는 클래스입니다. 주요 기능으로는 좌표값의 설정, 조회, 비교 등이 있습니다.

// 주요 메서드:
// Point(int x, int y): 주어진 x, y 좌표로 Point 객체를 생성합니다.
// int getX(): X 좌표 값을 반환합니다.
// int getY(): Y 좌표 값을 반환합니다.
// void setLocation(int x, int y): 좌표 값을 주어진 x, y로 설정합니다.
// void setLocation(Point p): 다른 Point 객체의 좌표 값을 현재 객체로 설정합니다.
// boolean equals(Object obj): 다른 객체와 현재 객체를 좌표 값 기준으로 비교하여 같은 좌표를 가지고 있는지
// 확인합니다.
// String toString(): Point 객체를 문자열로 표현한 값을 반환합니다. (예: "(x, y)")
// 해당 코드에서 Point 클래스는 큐에 저장할 좌표 정보를 표현하기 위해 사용됩니다.
// bfs 함수에서는 Queue<Point> 타입의 큐를 생성하여 좌표값을 Point 객체로 묶어 큐에 저장하고,
// 필요한 경우 좌표의 X와 Y 값을 조회하거나 설정하기 위해 Point 객체를 사용합니다.