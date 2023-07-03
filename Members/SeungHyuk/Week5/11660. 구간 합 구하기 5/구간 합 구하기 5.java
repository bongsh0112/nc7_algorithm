import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 구간 합 구하기 5
public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n+1][n+1];
    int[][] sumArr = new int[n+1][n+1];

    for (int i = 1; i <= n; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        arr[i][j] = Integer.parseInt(st2.nextToken());
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        sumArr[i][j] = arr[i][j] + sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1];
      }
    }
    StringBuffer sb = new StringBuffer();
    int ret = 0;
    for (int i = 0; i < m; i++) {
      StringTokenizer st3 = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st3.nextToken());
      int y1 = Integer.parseInt(st3.nextToken());
      int x2 = Integer.parseInt(st3.nextToken());
      int y2 = Integer.parseInt(st3.nextToken());

      ret = sumArr[x2][y2] - sumArr[x2][y1-1] - sumArr[x1-1][y2] + sumArr[x1-1][y1-1];
      sb.append(ret + "\n");
    }

    System.out.println(sb.toString());
  }
}
