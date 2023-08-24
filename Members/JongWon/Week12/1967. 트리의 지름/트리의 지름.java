import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    List<List<Node>> list = new ArrayList<>();

    for (int i = 0; i <= N; i++) {
      list.add(new ArrayList<>());
    }

    StringTokenizer st;
    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      list.get(parent).add(new Node(child, weight));
      list.get(child).add(new Node(parent, weight));
    }
    int[] visited = bfs(IntStream.range(0, N + 1).map(i -> -1).toArray(), list, 1);

    // 1에서 가장 먼곳 찾기
    int max = Integer.MIN_VALUE;
    int maxIdx = Integer.MIN_VALUE;
    for (int i = 0; i <= N; i++) {
      if (max < visited[i]) {
        max = visited[i];
        maxIdx = i;
      }
    }
    // 가장 먼곳에서 가장 먼곳 찾기
    visited = bfs(IntStream.range(0, N + 1).map(i -> -1).toArray(), list, maxIdx);
    System.out.println(Arrays.stream(visited).max().orElse(-1));
  }

  static int[] bfs(int[] visited, List<List<Node>> list, int start) {
    Queue<Integer> q = new LinkedList<>();
    visited[start] = 0;
    q.offer(start);
    while (!q.isEmpty()) {
      int temp = q.poll();
      for (Node near : list.get(temp)) {
        if (visited[near.num] != -1)
          continue;
        visited[near.num] = visited[temp] + near.weight;
        q.offer(near.num);
      }
    }
    return visited;
  }

  static class Node {
    int num;
    int weight;

    Node(int num, int weight) {
      this.num = num;
      this.weight = weight;
    }
  }

}
