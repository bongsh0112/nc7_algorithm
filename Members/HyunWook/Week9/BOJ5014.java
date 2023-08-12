// 5014 스타트링크 - BFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Queue<int[]> q = new LinkedList<int[]>();
    boolean visited[];
    boolean ans = false;

    int F = Integer.parseInt(st.nextToken()); // 건물 전체 층
    int S = Integer.parseInt(st.nextToken()); // 강호의 현재 층
    int G = Integer.parseInt(st.nextToken()); // 스타트 링크 위치 층
    int U = Integer.parseInt(st.nextToken()); // 위로 가는 버튼
    int D = Integer.parseInt(st.nextToken()); // 아래로 가는 버튼

    visited = new boolean[F + 1]; // 방문체크 하기 위함

    q.add(new int[] { S, 0 }); // 강호의 현재 층 넣기

    while (!q.isEmpty()) {
      int now = q.peek()[0];
      int depth = q.poll()[1];

      // 스타트링크 층에 도착했다면
      if (now == G) {
        System.out.println(depth);
        ans = true;
        break;
      }
      // 현재 층에 방문 했다면
      if (visited[now])
        continue;

      visited[now] = true; // 방문체크

      // 현재층에서 내려갈 곳이 있다면
      if (now - D >= 1) {
        q.offer(new int[] { now - D, depth + 1 });
      }
      // 현재층에서올라갈 곳이 있다면
      if (now + U <= F) {
        q.offer(new int[] { now + U, depth + 1 });
      }
    }
    if (!ans)
      System.out.println("use the stairs");
  }
}

// ### 알게된 점 ###
// peek() 메서드는 자바의 Queue 인터페이스를 구현한 자료구조(예: LinkedList, PriorityQueue 등)에서 사용되는
// 메서드로,
// 큐의 맨 앞에 있는 요소를 조회하고 반환하지만, 큐에서 해당 요소를 삭제하지 않습니다.