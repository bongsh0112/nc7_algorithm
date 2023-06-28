import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  
  static StringBuffer stringBuffer;
  static boolean[] check;
  static int[][] nodes;
  static int N; // node의 개수
  static int M; // 라인의 개수
  static int V; // 컴퓨터의 번호
  static int count;
  static Queue<Integer> queue = new LinkedList<>();
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(bufferedReader.readLine());
    M = Integer.parseInt(bufferedReader.readLine());
    check = new boolean[N + 1];
    nodes = new int[N + 1][N + 1];
    
    for (int i = 0; i < M; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      int a = Integer.parseInt(str[0]);
      int b = Integer.parseInt(str[1]);
      nodes[a][b] = nodes[b][a] = 1;
    }
   
    count = 0;
    bfs(1);
    System.out.println(count);
    
//    count = 0;
//    dfs(1);
//    System.out.println(count);
  }
  
  static void bfs(int start) {
    check[start] = true;
    queue.offer(start);
    
    while (!queue.isEmpty()) {
      V = queue.poll();
      check[V] = true;
      
      for(int i = 1 ; i <= N ; i++) {
        if (nodes[V][i] == 1 && !check[i]) {
          queue.offer(i);
          check[i] = true;
          count++;
        }
      }
    }
  }
  
  static void dfs(int start) {
    check[start] = true;
    
    for (int i = 0; i <= N; i++) { // 숫자가 작은 순서대로 탐색하기 때문에 오름차순으로 올라간다
      if (nodes[start][i] == 1 && !check[i]) { // 간선이 있으며 아직 탐색당하지 않은 노드에 대하여 다시 dfs 수행
        count++;
        dfs(i);
      }
    }
  }
}
