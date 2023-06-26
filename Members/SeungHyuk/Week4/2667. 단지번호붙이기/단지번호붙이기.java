import java.io.*;
import java.util.*;

// 단지 번호 붙이기
public class Main {
  static int n;
  static int[][] map;
  static boolean [][] visited;
  static StringBuilder sb = new StringBuilder();
  static int cnt;
  static ArrayList<Integer> cntArr;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    n = Integer.parseInt(br.readLine());
    map = new int[n+1][n+1];
    visited = new boolean[n+1][n+1];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(str[j]);
      }
    }

    cntArr = new ArrayList<Integer>();
    int total = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 1 && visited[i][j] == false) {
          dfs(i,j);
          cntArr.add(cnt);
          cnt = 0;
          total++;
        }
      }
    }
    Collections.sort(cntArr);
    for (Integer i : cntArr) {
      sb.append(""+ i + "\n");
    }

    System.out.println(total + "\n" + sb);
  }

  public static void dfs(int i, int j) {
    if (i >= 0 && j >= 0 && i < n && j < n) {
      if (map[i][j] == 1 && visited[i][j] == false) {
        visited[i][j] = true;
        cnt++;
        dfs(i-1, j);
        dfs(i, j-1);
        dfs(i+1, j);
        dfs(i, j+1);
      }
    }
  }
}
