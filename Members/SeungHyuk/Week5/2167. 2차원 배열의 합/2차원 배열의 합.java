import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2차원 배열의 합
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
  
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N+1][M+1];
    int[][] sumArr = new int[N+1][M+1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        sumArr[i][j] = arr[i][j] + sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1];
      }
    }
    
    int tc = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    
    for (int i = 0; i < tc; i++) {
        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        
        int ret = sumArr[y2][x2] - sumArr[y2][x1-1] - sumArr[y1-1][x2] + sumArr[y1-1][x1-1];
        sb.append(ret + "\n");
    }
    System.out.println(sb.toString());
  }
}
