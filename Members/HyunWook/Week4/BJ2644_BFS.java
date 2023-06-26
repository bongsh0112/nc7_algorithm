// 2644 촌수계산 - BFS

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int n, m, start, end;
  static int[][] graph;
  static int[] dist;

  public static void bfs(int index) {
    // BFS 함수는 큐를 사용하여 너비 우선 탐색을 수행합니다.
    Queue<Integer> que = new LinkedList<Integer>();
    // 시작 사람 start를 큐에 추가합니다.
    que.add(index);

    // 큐가 빌 때까지 다음 과정을 반복합니다.
    while (!que.isEmpty()) {
      // 큐에서 한 사람을 꺼내고 temp 변수에 저장합니다.
      int temp = que.poll();

      // 만약 temp가 도착 사람 end와 같다면 반복을 종료합니다.
      if (temp == end)
        break;

      // temp와 연결된 사람들을 찾아서 큐에 추가하고, 해당 사람의 촌수를 기록합니다.
      // 기록된 촌수는 이전 사람의 촌수에서 1을 더한 값입니다.
      for (int i = 1; i <= n; i++) {
        if (graph[temp][i] == 1 && dist[i] == 0) {
          que.add(i);
          dist[i] = dist[temp] + 1;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    graph = new int[n + 1][n + 1];
    dist = new int[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());

    // BFS 함수를 호출하여 시작 사람 start에서 도착 사람 end까지의 촌수를 계산합니다.
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph[x][y] = graph[y][x] = 1;
    }

    bfs(start);

    // 도착 사람의 촌수가 0이면 도달할 수 없는 경우이므로 -1을 출력합니다. 그렇지 않으면 도착 사람의 촌수를 출력합니다.
    System.out.println(dist[end] == 0 ? -1 : dist[end]);
  }
}