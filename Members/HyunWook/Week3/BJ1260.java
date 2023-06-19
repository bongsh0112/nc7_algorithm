
// 1260 DFS와 BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static StringBuilder sb = new StringBuilder();
  static boolean[] check;
  static int[][] arr;
  static int node, line, start;
  static Queue<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    node = Integer.parseInt(st.nextToken());
    line = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    arr = new int[node + 1][node + 1];
    check = new boolean[node + 1];

    for (int i = 0; i < line; i++) {
      StringTokenizer str = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(str.nextToken());
      int b = Integer.parseInt(str.nextToken());

      arr[a][b] = arr[b][a] = 1;
    }
    dfs(start);
    sb.append("\n");
    check = new boolean[node + 1];

    bfs(start);
    System.out.println(sb);

  }
  // DFS (깊이 우선 탐색) 구현:
  // dfs(int start): DFS를 수행하는 함수입니다. 시작 노드(start)를 인자로 받습니다.
  // check[start] = true: 현재 노드를 방문했음을 표시하기 위해 check 배열의 해당 인덱스를 true로 설정합니다.
  // sb.append(start + " "): 현재 노드를 출력 문자열(sb)에 추가합니다.
  // for (int i = 0; i <= node; i++): 모든 노드에 대해 반복합니다.
  // arr[start][i] == 1 && !check[i]: 현재 노드와 연결된 노드 중 방문하지 않은 노드를 찾습니다.
  // dfs(i): 해당 노드로 재귀적으로 DFS를 수행합니다.

  public static void dfs(int start) {
    check[start] = true;
    sb.append(start + " ");

    for (int i = 0; i <= node; i++) {
      if (arr[start][i] == 1 && !check[i])
        dfs(i);
    }
  }
  // BFS (너비 우선 탐색) 구현:
  // bfs(int start): BFS를 수행하는 함수입니다. 시작 노드(start)를 인자로 받습니다.
  // q.add(start): 시작 노드를 큐(q)에 추가합니다.
  // check[start] = true: 현재 노드를 방문했음을 표시하기 위해 check 배열의 해당 인덱스를 true로 설정합니다.
  // while (!q.isEmpty()): 큐가 비어있지 않은 동안 반복합니다.
  // start = q.poll(): 큐에서 노드를 하나 꺼내고, start 변수에 저장합니다.
  // sb.append(start + " "): 꺼낸 노드를 출력 문자열(sb)에 추가합니다.
  // for (int i = 1; i <= node; i++): 모든 노드에 대해 반복합니다.
  // arr[start][i] == 1 && !check[i]: 현재 노드와 연결된 노드 중 방문하지 않은 노드를 찾습니다.
  // q.add(i): 해당 노드를 큐에 추가합니다.
  // check[i] = true: 해당 노드를 방문했음을 표시하기 위해 check 배열의 해당 인덱스를 true로 설정합니다.

  public static void bfs(int start) {
    q.add(start);
    check[start] = true;

    while (!q.isEmpty()) {
      start = q.poll();
      sb.append(start + " ");

      for (int i = 1; i <= node; i++) {
        if (arr[start][i] == 1 && !check[i]) {
          q.add(i);
          check[i] = true;
        }
      }
    }
  }
}

// BFS 와 DFS
// BFS와 DFS는 그래프 탐색 알고리즘 중 가장 기본적인 두 가지 방법입니다.
// 이들은 주어진 그래프에서 노드를 탐색하고 연결된 모든 노드를 방문하는 데 사용됩니다.

// BFS (너비 우선 탐색) - (Breadth-First Search):
// BFS는 그래프 탐색을 수평적으로 진행하는 알고리즘입니다. 즉, 같은 레벨에 있는 모든 노드를 먼저 탐색한 후에 다음 레벨로 넘어갑니다.
// BFS는 큐(Queue) 자료구조를 사용하여 구현됩니다.
// 시작 노드를 큐에 넣고, 큐에서 노드를 하나씩 꺼내면서 그와 연결된 노드를 큐에 추가합니다.
// 큐에 담긴 노드값들을 순차적으로 poll() 하면서 큐 자료를 삭제하면서 다음 노드 값으로 이동한다.
// BFS는 가까운 노드부터 순차적으로 탐색하기 때문에 최단 경로를 찾는 문제에 자주 활용됩니다.
// 동일 깊이의 노드값들을 순회하면서 마지막 노드에 다다르게 된다.

// DFS (깊이 우선 탐색) - (Depth-First Search):
// DFS는 그래프 탐색을 깊이 방향으로 진행하는 알고리즘입니다. 즉, 한 경로를 따라 끝까지 탐색한 후에 다음 경로로 넘어갑니다.
// DFS는 스택(Stack) 자료구조를 사용하여 구현됩니다. 시작 노드를 스택에 넣고,
// 스택에서 노드를 하나씩 꺼내면서 그와 연결된 노드를 스택에 추가합니다.
// DFS는 모든 분기를 탐색하고자 할 때 유용하며, 그래프 내에 특정한 경로가 존재하는지 여부를 확인하는 문제에 자주 활용됩니다.
// 요약하면, BFS는 너비 우선으로 그래프를 탐색하며 가까운 노드부터 차례로 방문하고,
// DFS는 깊이 우선으로 그래프를 탐색하며 한 경로를 끝까지 탐색한 후 다른 경로로 넘어갑니다.
// 인접행렬 자료구조와 재귀 알고리즘을 사용하여 구현 가능, 인접행렬은 대칭행렬의 모습을 가지고 있다.
// 노드의 시작은 1부터 시작하고, 가장 깊은 곳의 노드까지 방문을 마치면 다음 자식노드로 이동해서 노드의 끝까지 이동하게 된다.