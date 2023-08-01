import java.io.*;
import java.util.*;

// 덩치
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];
    int[] rank = new int[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
          rank[i]++;
        }
      }
      rank[i]++;
    }

    for (int i = 0; i < n; i++) {
      sb.append(rank[i] + " ");
     }

     System.out.print(sb);
  }
}