import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
  
  static ArrayList<Integer>[] graph;
  static int[] arr;
  static int N;
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    N = Integer.parseInt(bufferedReader.readLine());
    arr = new int[N + 1]; // 1번 노드부터 N번 노드까지의 부모 노드 입력할 배열
    graph = new ArrayList[N + 1]; // 행이 arraylist인 2차원 배열(?)
    
    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }
    
    for (int i = 0; i < N - 1; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      int u = Integer.parseInt(str[0]);
      int v = Integer.parseInt(str[1]);
      graph[u].add(v);
      graph[v].add(u);
    }
    dfs(1);
    
    for (int i = 2; i < N + 1; i++) {
      System.out.println(arr[i]);
    }
  }
  
  static void dfs(int x) {
    for (int i : graph[x]) {
      if (arr[i] == 0) {
        arr[i] = x;
        dfs(i);
      }
    }
  }
  
}