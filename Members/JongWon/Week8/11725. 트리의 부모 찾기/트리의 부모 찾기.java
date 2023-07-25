import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static List<List<Integer>> map = new ArrayList<>();
  private static int[] parent;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;

    parent = new int[N + 1];
    Arrays.fill(parent, -1);
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<Integer>());
    }

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      map.get(start).add(end);
      map.get(end).add(start);
    }
    parent[1] = 1;
    dfs(1);
    StringBuffer sb = new StringBuffer();
    for (int i = 2; i <= N; i++) {
      sb.append(parent[i] + "\n");
    }
    System.out.println(sb);
  }

  private static void dfs(int n) {
    List<Integer> getlist = map.get(n);
    for (int child : getlist) {
      if (parent[child] == -1) {
        parent[child] = n;
        dfs(child);
      }
    }
  }
}