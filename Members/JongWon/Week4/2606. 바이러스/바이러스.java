import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

// 시작번호는 무조건 1번이다
public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    // 초기화, M미만이 아닌 M이하로 한 이유는 .get(0)을 사용하지 않기 위해서
    for (int i = 0; i <= N; i++) {
      list.add(new ArrayList<Integer>());
    }

    for (int i = 1; i <= M; i++) {
      String[] fromTo = br.readLine().split(" ");
      int from = Integer.parseInt(fromTo[0]);
      int to = Integer.parseInt(fromTo[1]);
      list.get(from).add(to);
      list.get(to).add(from);
    }

    // new dfs(list, N);
    new bfs(list, N);
  }
}

class dfs {
  private ArrayList<ArrayList<Integer>> node;
  private boolean[] visited;

  public dfs(ArrayList<ArrayList<Integer>> node, int N) {
    this.node = node;
    this.visited = new boolean[N + 1];
    Arrays.fill(visited, false);
    dfsRun(1);
    System.out.println(IntStream.range(1, N + 1).filter(i -> i != 1 && visited[i]).count());
  }

  private void dfsRun(int num) {
    visited[num] = true;
    ArrayList<Integer> numList = node.get(num);
    for (int i = 0; i < numList.size(); i++) {
      int idx = numList.get(i);
      if (!visited[idx]) {
        dfsRun(idx);
      }
    }

  }
}

class bfs {
  private ArrayList<ArrayList<Integer>> node;
  private boolean[] visited;

  public bfs(ArrayList<ArrayList<Integer>> node, int N) {
    this.node = node;
    this.visited = new boolean[N + 1];
    Arrays.fill(visited, false);

    bfsRun(1);
    System.out.println(IntStream.range(1, N + 1).filter(i -> i != 1 && visited[i]).count());
  }

  private void bfsRun(int num) {
    LinkedList<Integer> bfsQueue = new LinkedList<>();
    bfsQueue.add(num);

    while (!bfsQueue.isEmpty()) {
      int node = bfsQueue.poll();
      visited[node] = true;
      ArrayList<Integer> nodeList = this.node.get(node);

      for (int i = 0; i < nodeList.size(); i++) {
        if (!visited[nodeList.get(i)]) {
          bfsQueue.add(nodeList.get(i));
        }
      }
    }
  }

}