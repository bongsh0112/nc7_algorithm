import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {

  static StringBuffer stringBuffer;
  static boolean[] check;
  static int[][] nodes;
  static int N;
  static int M;
  static int V;
  static Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {

//    24816KB	304ms

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    stringBuffer = new StringBuffer();

    String[] nums = bufferedReader.readLine().split(" ");
    N = Integer.parseInt(nums[0]);
    M = Integer.parseInt(nums[1]);
    V = Integer.parseInt(nums[2]);

    check = new boolean[N + 1];
    nodes = new int[N + 1][N + 1];

    for (int i = 0; i < M; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      int a = Integer.parseInt(str[0]);
      int b = Integer.parseInt(str[1]);
      nodes[a][b] = nodes[b][a] = 1;
    }

    dfs(V);
    stringBuffer.append("\n");
    Arrays.fill(check, false);

    bfs(V);

    System.out.println(stringBuffer.toString());

  }

  public static void dfs(int V) {
    check[V] = true;
    stringBuffer.append(V + " ");

    for (int i = 0; i <= N; i++) { // 숫자가 작은 순서대로 탐색하기 때문에 오름차순으로 올라간다
      if (nodes[V][i] == 1 && !check[i]) { // 간선이 있으며 아직 탐색당하지 않은 노드에 대하여 다시 dfs 수행
        dfs(i);
      }
    }
  }

  public static void bfs(int V) {
    queue.add(V);
    check[V] = true;

    while(!queue.isEmpty()) {

      V = queue.poll(); // poll() - Returns and removes the head of the queue. Returns null if the queue is empty.
      stringBuffer.append(V + " ");

      for(int i = 1 ; i <= N ; i++) {
        if(nodes[V][i] == 1 && !check[i]) {
          queue.add(i);
          check[i] = true;
        }
      }
    }
  }

}
