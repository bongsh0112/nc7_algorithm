import java.io.*;
import java.util.*;

public class Main {
  static int arr[][];
  static boolean visited[];
  static int N, M, cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N+1][N+1];
    visited = new boolean[N+1];

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      arr[x][y] = 1;
      arr[y][x] = 1;
    }

    cnt = 0;
    for(int i=1; i<=N; i++) {	
      if(visited[i] == false) {
      DFS(i);
      cnt++;
      }
    }
    System.out.println(cnt);
  }

  public static void DFS(int cur) {
    if(visited[cur] == true) return;

    visited[cur] = true;
    for(int i = 1; i <= N; i++) {
      if(arr[cur][i] == 1) {
        DFS(i);
      }
    }
  }
}