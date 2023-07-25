import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 그래프가 몇 개가 나오는지를 찾는 문제 */
public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static List<List<Integer>> map = new ArrayList<>();
  private static boolean[] visited;

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];

    // List 초기화
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      map.get(start).add(end);
      map.get(end).add(start);
    }

    int count = 0;
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }
    }
    System.out.println(count);
  }

  private static void dfs(int num) {
    visited[num] = true;
    List<Integer> nList = map.get(num);
    for (int nNum : nList) {
      if (!visited[nNum])
        dfs(nNum);
    }

  }
}
