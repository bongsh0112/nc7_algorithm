// 11725 트리의 부모 찾기 - BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  // ArrayList를 사용하여 그래프를 구현하고, 각 노드에 해당하는 ArrayList를 초기화합니다.
  static ArrayList<ArrayList<Integer>> tree;
  // parent 배열은 노드의 부모 노드를 저장하기 위한 배열로, N+1 크기로 초기화합니다. (인덱스 1부터 사용)
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 노드의 개수 N

    tree = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      tree.add(new ArrayList<>());
    }
    parent = new int[N + 1];

    // N-1개의 줄에 걸쳐서 연결된 두 정점 u와 v를 입력받습니다.
    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      // 양방향 그래프이므로, tree 리스트에 u와 v를 서로 추가해줍니다.
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    bfs();

    // 2번 노드부터 N번 노드까지 순차적으로 parent 배열을 출력하여 각 노드의 부모 노드를 확인합니다.
    for (int i = 2; i <= N; i++) {
      System.out.println(parent[i]);
    }
  }

  // BFS 탐색을 위한 큐(Queue)와 방문 여부를 체크하기 위한 visited 배열을 준비합니다.
  static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[parent.length];

    // 큐에 루트 노드인 1을 추가하고, visited[1]을 true로 설정합니다. (루트 노드는 부모 노드가 없으므로 자기 자신으로 초기화)
    queue.add(1);
    visited[1] = true;

    // 큐가 비어질 때까지 반복하면서 BFS를 수행합니다.
    while (!queue.isEmpty()) {
      // 현재 큐에서 노드를 하나 꺼내고, 해당 노드와 연결된 자식 노드들을 순회합니다.
      int node = queue.poll();
      for (int child : tree.get(node)) {
        // 방문하지 않은 자식 노드라면, 현재 노드를 해당 자식 노드의 부모로 설정하고,
        // 큐에 자식 노드를 추가합니다. 그리고 방문 여부를 체크합니다.
        // 이렇게 진행하면 모든 노드의 부모 노드가 찾아집니다.
        if (!visited[child]) {
          // BFS 탐색이 끝나면, parent 배열에 모든 노드의 부모 노드가 저장되어 있습니다.
          parent[child] = node;
          queue.add(child);
          visited[child] = true;
        }
      }
    }
  }
}

// ### 문제를 DFS? BFS?
// DFS의 경우:
// 한 노드에서 모든 자식 노드를 순회하면서 부모 노드를 결정합니다.
// 트리의 높이가 깊어질수록 스택의 깊이가 커질 수 있으며, 재귀를 사용하므로 재귀 호출의 오버헤드가 있을 수 있습니다.

// BFS의 경우:
// 너비 우선 탐색으로 레벨별로 탐색합니다.
// 트리의 높이에 상관없이 레벨별로 순차적으로 탐색하므로 스택의 깊이를 걱정할 필요가 없습니다.
// 따라서, 트리의 부모를 구하는 문제에서는 BFS가 일반적으로 더 효율적입니다.