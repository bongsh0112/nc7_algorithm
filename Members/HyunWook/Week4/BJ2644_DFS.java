// 2644 촌수계산 - DFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 첫 번째 줄에서는 사람의 수 n을 입력받습니다.
  // 두 번째 줄에서는 시작 사람과 도착 사람의 번호인 start와 end를 입력받습니다.
  // 세 번째 줄에서는 관계의 수 m을 입력받습니다.
  // 다음 m개의 줄에 걸쳐 각 관계를 나타내는 x와 y를 입력받습니다.
  static int n, m, start, end;
  static int[][] graph;
  static int[] dist;

  public static void dfs(int index) {

    // 현재 위치 index와 연결된 사람들을 탐색합니다.
    // 만약 해당 사람이 도착 사람 end와 같다면 함수를 종료합니다.
    if (index == end)
      return;

    // 현재 사람과 연결된 사람들 중 아직 방문하지 않은 사람들을 찾아서 dist 배열에 촌수를 기록하고,
    // 해당 사람으로 DFS 함수를 재귀적으로 호출합니다.
    for (int i = 1; i <= n; i++) {
      if (graph[index][i] == 1 && dist[i] == 0) {
        dist[i] = dist[index] + 1;
        dfs(i);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 그래프 생성
    // n+1 x n+1 크기의 2차원 배열 graph를 생성합니다. 이는 사람들 간의 관계를 나타냅니다.
    // 관계가 있는 두 사람 사이의 연결을 나타내기 위해 graph[x][y]와 graph[y][x]를 1로 설정합니다.
    n = Integer.parseInt(br.readLine());
    graph = new int[n + 1][n + 1];
    dist = new int[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());

    // DFS 함수를 호출하여 시작 사람 start에서 도착 사람 end까지의 촌수를 계산합니다.
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph[x][y] = graph[y][x] = 1;
    }

    dfs(start);

    // 도착 사람의 촌수가 0이면 도달할 수 없는 경우이므로 -1을 출력합니다. 그렇지 않으면 도착 사람의 촌수를 출력합니다.
    System.out.println(dist[end] == 0 ? -1 : dist[end]);
  }
}