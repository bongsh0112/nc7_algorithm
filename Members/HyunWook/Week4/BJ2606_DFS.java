// 2606 바이러스 - DFS

import java.util.Scanner;

public class Main {
  // 컴퓨터 간 연결 관계를 나타내는 인접 행렬을 저장하는 변수입니다.
  // node[i][j]가 1이면 i번 컴퓨터와 j번 컴퓨터가 연결되어 있다는 것을 의미합니다.
  public static int[][] node;
  // 각 컴퓨터의 방문 여부를 저장하는 배열입니다. visited[i]가 true이면 i번 컴퓨터를 방문한 것을 의미합니다
  public static boolean[] visited;
  // 컴퓨터의 수를 저장하는 변수 M과 연결 정보의 수를 저장하는 변수 N입니다.
  public static int M, N;
  // 감염된 컴퓨터의 수를 저장하는 변수로, 초기값은 0입니다.
  public static int result = 0;

  // DFS 알고리즘을 구현한 메서드입니다. 현재 컴퓨터의 번호 x를 매개변수로 받습니다.
  public static void dfs(int x) {
    // 현재 컴퓨터를 방문했음을 표시합니다.
    visited[x] = true;
    // 감염된 컴퓨터 수를 1 증가시킵니다.
    result += 1;

    // 모든 컴퓨터를 순회
    for (int i = 0; i <= M; i++) {
      // 현재 컴퓨터와 i번 컴퓨터가 연결되어 있고, i번 컴퓨터를 방문하지 않았다면:
      if (node[x][i] == 1 && !visited[i]) {
        // i번 컴퓨터를 방문합니다..
        dfs(i);
      }
    }
  }

  // 프로그램의 시작점입니다
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    // 사용자로부터 컴퓨터의 수 M과 연결 정보의 수 N을 입력받습니다.
    M = sc.nextInt();
    N = sc.nextInt();

    // 인접 행렬 node를 M+1 크기로 초기화합니다.
    node = new int[M + 1][M + 1];
    // 방문 여부를 저장하는 배열 visited를 M+1 크기로 초기화합니다.
    visited = new boolean[M + 1];

    // 연결 정보를 입력받아 인접 행렬에 저장합니다.
    for (int i = 0; i < N; i++) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      // m번 컴퓨터와 n번 컴퓨터를 연결했음을 인접 행렬에 표시합니다.
      node[m][n] = node[n][m] = 1;
    }
    // 1번 컴퓨터부터 시작하여 DFS를 실행합니다.
    dfs(1);
    // 감염된 컴퓨터 수를 출력합니다. 여기서 -1을 하는 이유는 1번 컴퓨터는 이미 방문한 상태로 시작하기 때문입니다.
    System.out.println(result - 1);
  }
}
