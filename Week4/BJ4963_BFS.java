// 4963 섬의개수 - BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int w, h;
  static int map[][];
  static int dx[] = { 0, 0, -1, 1, -1, -1, 1, 1 };
  static int dy[] = { -1, 1, 0, 0, -1, 1, -1, 1 }; // 8방향 탐색
  static boolean isVisited[][];
  static Queue<Node> q = new LinkedList<>();
  static int island = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    while (true) {
      st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      if (w == 0 && h == 0)
        break;

      map = new int[h][w];
      isVisited = new boolean[h][w];
      island = 0;// 섬 갯수 초기화

      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++)
          map[i][j] = Integer.parseInt(st.nextToken());
      } // 지도 입력

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (map[i][j] == 1 && !isVisited[i][j]) {
            isVisited[i][j] = true;
            q.offer(new Node(i, j));
            bfs();
          }
        }
      }
      System.out.println(island);
      q.clear();

    }
  }

  static void bfs() {

    while (!q.isEmpty()) {
      Node node = q.poll();

      for (int d = 0; d < 8; d++) {
        int nx = node.x + dx[d];
        int ny = node.y + dy[d];

        if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 0 || isVisited[nx][ny])
          continue; // 배열 범위 벗어나면 그만두기

        // 방문하지도 않았고 섬이면
        isVisited[nx][ny] = true;
        q.offer(new Node(nx, ny)); // 큐에 넣어주기
      }
    }

    island++;

  }

  static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      super();
      this.x = x;
      this.y = y;
    }
  }

}

// 1. 입력 처리:
// BufferedReader를 사용하여 입력을 받습니다.
// while문을 사용하여 여러 개의 테스트 케이스를 처리합니다.
// 첫 번째 입력인 w와 h는 지도의 너비와 높이를 나타냅니다.
// w와 h가 0이면 입력이 종료되므로 while문을 종료합니다.
// 지도의 크기에 맞게 map 배열과 isVisited 배열을 초기화합니다.

// 2. 지도 입력:
// h만큼 반복하면서 한 줄씩 입력을 받습니다.
// 각 줄에는 w개의 숫자가 주어지며, 1은 땅을 나타내고 0은 바다를 나타냅니다.
// 입력받은 값을 map 배열에 저장합니다.

// 3. BFS 알고리즘:
// bfs 함수는 큐를 사용하여 너비 우선 탐색을 수행합니다.
// bfs 함수에서는 시작 노드인 (x, y)를 큐에 넣고 방문했음을 표시하기 위해 isVisited[x][y]를 true로 설정합니다.
// 큐가 비어있을 때까지 반복하며, 큐에서 노드를 하나씩 꺼냅니다.
// 꺼낸 노드의 상하좌우 및 대각선 방향을 탐색하여 인접한 땅을 찾습니다.
// 인접한 땅이 지도 내에 있고, 해당 땅을 방문하지 않았으며(map[nx][ny] == 1 && !isVisited[nx][ny]),
// 해당 땅이 땅(1)인 경우에 큐에 넣고 방문했음을 표시합니다.

// 4. 섬의 개수 구하기:
// 이중 반복문을 사용하여 지도의 모든 위치를 탐색합니다.
// 만약 현재 위치가 땅(1)이고 아직 방문하지 않았다면(!isVisited[i][j]), bfs 함수를 호출하여 해당 섬을 탐색합니다.
// bfs 함수가 호출되었을 때, 섬의 개수를 세기 위해 island를 1 증가시킵니다.
// 결과 출력:

// 각 테스트 케이스마다 구한 섬의 개수(island)를 출력합니다.