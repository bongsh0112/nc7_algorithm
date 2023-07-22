// 11724 연결 요소의 개수 - DFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 정점의 개수
    int M = Integer.parseInt(st.nextToken()); // 간선의 개수

    // 그래프 생성 (인접 리스트)
    // 정점의 개수 N에 따라 그래프의 인접 리스트를 초기화합니다. graph[i]는 정점 i와 연결된 정점들의 리스트를 담는 배열입니다.
    List<Integer>[] graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }
    // 간선 정보 입력
    // 양방향 그래프이므로 양쪽 정점 모두에 간선 정보를 추가합니다.
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()); // M개의 줄에 간선의 양 끝점
      int v = Integer.parseInt(st.nextToken()); // M개의 줄에 간선의 양 끝점
      // 양방향 그래프이므로 양쪽 정점 모두에 간선 정보를 추가
      graph[u].add(v);
      graph[v].add(u);
    }
    // 방문 여부를 저장하는 배열
    boolean[] visited = new boolean[N + 1];
    int connectedComponents = 0;

    // 모든 정점에 대해 DFS를 수행하면서 연결 요소 개수를 셉니다.
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        connectedComponents++;
        dfs(graph, i, visited);
      }
    }
    System.out.println(connectedComponents);
  }

  // DFS 함수
  // DFS 함수에서는 현재 정점을 방문 표시하고, 해당 정점과 연결된 모든 정점들에 대해 재귀적으로 DFS를 수행합니다.
  // 방문하지 않은 정점을 만나면 해당 정점을 시작으로 DFS를 수행합니다.
  // DFS가 종료되면 해당 연결 요소에 속하는 모든 정점들이 방문 처리되게 됩니다.
  private static void dfs(List<Integer>[] graph, int start, boolean[] visited) {
    visited[start] = true;
    for (int next : graph[start]) {
      if (!visited[next]) {
        dfs(graph, next, visited);
      }
    }
  }
}

// ### DFS로 해결해야 하는 이유 :

// 이 문제는 넓이 우선 탐색(BFS)으로도 해결할 수 있습니다.
// 하지만 넓이 우선 탐색은 깊이 우선 탐색(DFS)보다 복잡한 구현을 요구하기 때문에
// 일반적으로 DFS를 사용하여 문제를 해결하는 것이 더 간단합니다.

// BFS를 사용하여 이 문제를 해결하려면 큐(Queue)를 사용하여 정점을 탐색하면서 연결된 정점을 방문하고,
// 연결 요소의 개수를 세는 방식으로 구현해야 합니다. BFS를 이용하면 최단 거리 문제를 해결할 수 있으므로
// 이 문제도 BFS로 해결할 수는 있지만, DFS보다 구현이 더 복잡해지기 때문에 일반적으로는 DFS를 사용하여 해결합니다.
// 따라서, 이 문제를 간단하게 해결하기 위해서는 DFS를 사용하는 것이 더 좋습니다.

// ### 예제 입력 2를 기준으로 동작을 설명 :

// 1번 정점을 시작으로 DFS를 수행합니다. 1번 정점에 연결된 정점들은 2와 5입니다.
// 따라서 1, 2, 5번 정점들이 연결되어 있음을 알 수 있습니다. 이 정점들을 모두 방문처리합니다.

// 3번 정점을 시작으로 DFS를 수행합니다. 3번 정점에 연결된 정점은 4입니다.
// 따라서 3과 4번 정점이 연결되어 있음을 알 수 있습니다. 이 정점들을 모두 방문처리합니다.

// 6번 정점을 시작으로 DFS를 수행합니다. 6번 정점에 연결된 정점은 4입니다.
// 따라서 6과 4번 정점이 연결되어 있음을 알 수 있습니다. 이 정점들을 모두 방문처리합니다.

// 2번 정점을 시작으로 DFS를 수행합니다. 2번 정점에 연결된 정점은 1, 5, 4, 3입니다.
// 1, 2, 5는 이미 이전에 방문한 정점이기 때문에 DFS를 수행하지 않고, 4번 정점을 시작으로 DFS를 수행합니다.

// 4번 정점에 연결된 정점은 6과 3입니다. 6과 3은 이미 이전에 방문한 정점이기 때문에 DFS를 수행하지 않습니다.
// 이제 모든 정점을 방문하였고, 연결 요소의 개수를 1 증가시킵니다.
// 따라서 주어진 그래프에서는 연결 요소의 개수가 1개이므로, 출력은 1이 됩니다.