import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
  
  static int[][] graph = new int[1001][1001];
  static int N;
  static int M;
  static boolean[] checked = new boolean[1001];
  
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] str = bufferedReader.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);
    
    for (int i = 0; i < M; i++) {
      str = bufferedReader.readLine().split(" ");
      int u = Integer.parseInt(str[0]);
      int v = Integer.parseInt(str[1]);
      graph[u][v] = graph[v][u] = 1;
    }
    
    int count = 0;
    
    for (int i = 1; i <= N; i++) {
      if (checked[i] == false) {
        dfs(i);
        count++;
      }
    }
    
    System.out.println(count);
    
  }
  
  static void dfs(int x) {
    if (checked[x] == false) {
      checked[x] = true;
      for (int i = 1; i <= N; i++) {
        if (graph[x][i] == 1 && graph[i][x] == 1) {
          dfs(i);
        }
      }
    }
  }
  
}