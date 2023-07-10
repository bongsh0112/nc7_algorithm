import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int N, M;

  private static String[][] map;
  private static PriorityQueue<MstNode> pq = new PriorityQueue<>();
  private static List<Node> list = new ArrayList<>();

  private static int[] dx = { 1, -1, 0, 0 };
  private static int[] dy = { 0, 0, 1, -1 };
  private static int[] parent;

  public static void main(String[] args) throws Exception {
    /*
     * 1: 벽, 0: 지나다닐수 있는 길, S: 로봇의 출발 위치, K열쇠의 위치
     * 즉 S와 K 는 모두 "정점"을 의미하며 S와 K에서 모든 "간선의 거리"을 찾아야 한다.
     */

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 사각형 크기
    M = Integer.parseInt(st.nextToken()); // 열쇠의 갯수

    map = new String[N][N];

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().split("");
    }

    // S를 맨 앞에,K는 1번방부터.
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j].equals("S")) {
          list.add(0, new Node(i, j));
        }
        if (map[i][j].equals("K")) {
          list.add(new Node(i, j));
        }
      }
    }
    // 정점의 갯수 M(K) + S(1)
    for (int i = 0; i < M + 1; i++) {
      bfs(i);
    }
    System.out.println(mst());
  }

  private static int mst() {
    parent = new int[M + 1];
    for (int i = 0; i < M + 1; i++) {
      parent[i] = i;
    }
    int sum = 0;
    int nodeCount = 0;
    while (!pq.isEmpty()) {
      MstNode n = pq.poll();
      int sPar = getParent(n.s);
      int ePar = getParent(n.e);
      if (sPar != ePar) {
        unionParent(sPar, ePar);
        sum += n.cost;
        nodeCount++;
      }
    }
    if (M == nodeCount)
      return sum;
    return -1;
  }

  // 부모 노드를 찾는 함수
  private static int getParent(int node) {
    if (parent[node] == node)
      return node;
    return parent[node] = getParent(parent[node]);
  }

  // 두개의 부모 노드를 합치는 함수
  private static void unionParent(int a, int b) {
    if (a > b)
      parent[a] = b;
    else
      parent[b] = a;
  }

  private static void bfs(int nodeNum) {
    Queue<Node> q = new LinkedList<>();
    Node stNode = list.get(nodeNum);
    q.offer(stNode);
    int[][] visited = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(visited[i], -1);
    }
    visited[stNode.x][stNode.y] = 0;

    while (!q.isEmpty()) {
      Node n = q.poll();
      for (int i = 0; i < 4; i++) {
        int tx = n.x + dx[i];
        int ty = n.y + dy[i];

        if (tx < 0 || ty < 0 || tx >= N || ty >= N)
          continue;
        if (visited[tx][ty] != -1 || map[tx][ty].equals("1"))
          continue;

        // 거리 기록
        visited[tx][ty] = visited[n.x][n.y] + 1;
        q.offer(new Node(tx, ty));

        // 어떤 노드와 연결 된 것인지 확인
        if (map[tx][ty].equals("S") || map[tx][ty].equals("K")) {
          for (int j = 0; j < M + 1; j++) {
            Node compareNode = list.get(j);
            if (tx == compareNode.x && ty == compareNode.y) {
              pq.offer(new MstNode(nodeNum, j, visited[tx][ty]));
            }
          }
        }
      }
    }

  }

  // PiroityQueue를 구현하기 위한 상속..
  static class MstNode implements Comparable<MstNode> {
    int s, e, cost;

    MstNode(int s, int e, int cost) {
      this.s = s;
      this.e = e;
      this.cost = cost;
    }

    @Override
    public int compareTo(MstNode n) {
      return this.cost - n.cost;
    }
  }

  static class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
