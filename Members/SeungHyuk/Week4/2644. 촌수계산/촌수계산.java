import java.util.*;
import java.io.*;
// 촌수계산
public class Main {
  static int node, edge, start, end;
  static ArrayList<Integer>[] graph;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    node = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    edge = Integer.parseInt(br.readLine());

    dist = new int[node + 1];
    graph = new ArrayList[node + 1];

    for (int i = 1; i <= node; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 1; i <= edge; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph[x].add(y);
      graph[y].add(x);
    }

    Arrays.fill(dist, -1);
    bfs(start);

    System.out.println(dist[end]);
  }

  static void bfs(int x) {
    Queue<Integer> q= new LinkedList<>();
    q.add(x);
    dist[x] = 0;

    while(!q.isEmpty()) {
      x = q.poll();

      for (int y : graph[x]) {
        if (dist[y] != -1)
          continue;
        q.add(y);
        dist[y] = dist[x] + 1;
      }
    }
    
  }

}
