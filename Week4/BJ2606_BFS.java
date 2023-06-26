// 2606 바이러스 - BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  // 컴퓨터 간 연결 관계를 나타내는 인접 행렬을 저장하는 변수!
  // node[i][j]가 1이면 i번 컴퓨터와 j번 컴퓨터가 연결되어 있다는 것을 의미
  public static int[][] node;
  // 각 컴퓨터의 방문 여부를 저장하는 배열입니다. visited[i]가 true이면 i번 컴퓨터를 방문한 것을 의미
  public static boolean[] visited;
  // 컴퓨터의 수를 저장하는 변수 M과 연결 정보의 수를 저장하는 변수 N입니다.
  public static int M, N;
  // 감염된 컴퓨터의 수를 저장하는 변수로, 초기값은 0입니다.
  public static int result = 0;

  // BFS 알고리즘을 구현한 메서드입니다. 시작 컴퓨터의 번호인 start를 매개변수로 받습니다.
  public static int bfs(int start) {
    // 방문할 컴퓨터를 저장하기 위한 큐인 que를 선언합니다.
    Queue<Integer> que = new LinkedList<>();
    // 시작 컴퓨터를 방문했음을 표시합니다.
    visited[start] = true;
    // 시작 컴퓨터를 큐에 넣습니다.
    que.offer(start);

    // 큐가 비어있지 않은 동안 다음 작업을 반복합니다.
    while (!que.isEmpty()) {
      // 큐에서 컴퓨터를 하나 꺼내서 temp 변수에 저장합니다.
      int temp = que.poll();

      // 모든 컴퓨터를 순회합니다.
      for (int i = 1; i <= M; i++) {
        // 현재 컴퓨터와 i번 컴퓨터가 연결되어 있고, i번 컴퓨터를 방문하지 않았다면:
        if (node[temp][i] == 1 && !visited[i]) {
          // i번 컴퓨터를 큐에 넣습니다.
          que.offer(i);
          // i번 컴퓨터를 방문했음을 표시합니다.
          visited[i] = true;
          // 감염된 컴퓨터 수를 1 증가시킵니다.
          result++;
        }
      }
    }
    // 최종적으로 감염된 컴퓨터 수를 반환합니다.
    return result;
  }

  // 프로그램의 시작점
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    M = sc.nextInt();
    N = sc.nextInt();

    // 인접 행렬 node를 M+1 크기로 초기화합니다.
    node = new int[M + 1][M + 1];
    // 방문 여부를 저장하는 배열 visited를 M+1 크기로 초기화합니다.
    visited = new boolean[M + 1];

    // 연결 정보를 입력받아 인접 행렬에 저장합니다.
    for (int i = 0; i < N; i++) {
      // 연결된 두 컴퓨터의 번호 m과 n을 입력받습니다.
      int m = sc.nextInt();
      int n = sc.nextInt();
      // m번 컴퓨터와 n번 컴퓨터를 연결했음을 인접 행렬에 표시합니다.
      node[m][n] = node[n][m] = 1;
    }
    // 1번 컴퓨터부터 시작하여 BFS를 실행하고, 감염된 컴퓨터 수를 출력합니다.
    System.out.println(bfs(1));
  }
}

// https://141227.tistory.com/156 : 참조(정리잘됌)
