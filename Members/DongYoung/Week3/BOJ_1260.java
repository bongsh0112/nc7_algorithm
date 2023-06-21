
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 정점의 갯수
    int m = sc.nextInt(); // 간선의 개수
    int v = sc.nextInt(); // 탐색을 시작할 정점의 번호

    int[][] adjArr = new int[n + 1][n + 1]; // BFS용 그래프 행렬
    // 두 정점 사이에 여러 개의 간선이 있을 수 있다.
    // 입력으로 주어지는 간선은 양방향이다.
    for (int i = 0; i < m; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();

      adjArr[v1][v2] = 1;
      adjArr[v2][v1] = 1;
    }
    System.out.println("DFS - 인접행렬");
    dfsArray(v, adjArr, new boolean[n + 1]);
    System.out.println("BFS - 인접행렬");
    bfsArray(v, adjArr, new boolean[n + 1]);
    System.out.println();
    sc.close();

  }

  public static void bfsArray(int v, int[][] adjArr, boolean[] visited) {
    Queue<Integer> q = new LinkedList<>();
    int n = adjArr.length - 1;

    q.add(v);
    visited[v] = true;
    while (!q.isEmpty()) {
      v = q.poll();
      System.out.print(v + " ");

      for (int i = 1; i <= n; i++) {
        if (adjArr[v][i] == 1 && !visited[i]) {
          q.add(i);
          visited[i] = true;
        }
      }
    }
  }

  public static void dfsArray(int v, int[][] adjArr, boolean[] visited) {
    int n = adjArr.length - 1;
    visited[v] = true;
    System.out.print(v + " ");
    for (int i = 1; i <= n; i++) {
      if (adjArr[v][i] == 1 && !visited[i]) {
        dfsArray(i, adjArr, visited);
      }
    }

  }
}
