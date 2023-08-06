import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static List<Integer>[] map;
  private static int[] visited;

  // 건물은 1층부터
  public static void main(String[] args) throws Exception {
    String[] input = br.readLine().split(" ");

    int F = Integer.parseInt(input[0]); // 전체 층 수
    int S = Integer.parseInt(input[1]); // 시작 층 수
    int G = Integer.parseInt(input[2]); // 도착 층 수
    int U = Integer.parseInt(input[3]); // Up시 이동
    int D = Integer.parseInt(input[4]); // Down시 이동

    visited = new int[F + 1];
    Arrays.fill(visited, -1);

    map = new ArrayList[F + 1];
    for (int i = 0; i <= F; i++) {
      map[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i <= F; i++) {
      if (U != 0 && i + U <= F)
        map[i].add(i + U);
      if (D != 0 && i - D >= 1)
        map[i].add(i - D);
    }

    Queue<Integer> q = new LinkedList<>();
    visited[S] = 0;
    q.offer(S);
    while (!q.isEmpty()) {
      int now = q.poll();
      for (int idx : map[now]) {
        if (visited[idx] == -1) {
          q.offer(idx);
          visited[idx] = visited[now] + 1;
        }
      }
    }
    System.out.println(visited[G] == -1 ? "use the stairs" : visited[G]);
  }
}
