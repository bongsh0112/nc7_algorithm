import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;
  static int M;
  static boolean visited[];
  static int[] arr;
  static StringBuilder stringBuilder = new StringBuilder();
  
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] str = bufferedReader.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);
    
    visited = new boolean[N];
    arr = new int[M];
    
    dfs(0);
    System.out.println(stringBuilder.toString());
    
  }
  
  static void dfs(int depth) { // depth : 순열에서 골라야 하는 수의 개수
    if (depth == M) {
      for (int i : arr) {
        stringBuilder.append(i + " ");
      }
      stringBuilder.append("\n");
      return;
    }
    
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i + 1;
        dfs(depth + 1);
        visited[i] = false; // 일단 dfs로 모두 순회하고 나면 i번쨰는 false로 바꾸어준다.
      }
    }
  }
  
}