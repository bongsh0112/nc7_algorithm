import java.util.*;
import java.io.*;
// 구간합 구하기
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n+1];

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for(int i = 1; i <= n; i++) {
      arr[i] += arr[i - 1] + Integer.parseInt(st2.nextToken());
    }

    for(int i = 0; i < m; i++) {
      StringTokenizer st3 = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st3.nextToken());
      int b = Integer.parseInt(st3.nextToken());
      sb.append(arr[b] - arr[a - 1] + "\n");
    }
    System.out.println(sb);
  }
}
