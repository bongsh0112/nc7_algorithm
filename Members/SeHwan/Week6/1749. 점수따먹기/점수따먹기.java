import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);
    
    int[][] arr = new int[N + 1][M + 1];
    
    // S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + 현재값
    for (int i = 1; i <= N; i++) {
      str = bufferedReader.readLine().split(" ");
      for (int j = 1; j <= M; j++) {
        arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + Integer.parseInt(str[j-1]);
      }
    } // 누적합 배열 채우기
    
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        for (int k = i; k <= N; k++) {
          for (int l = j; l <= M; l++) {
            int temp = arr[k][l] - arr[i-1][l] - arr[k][j-1] + arr[i-1][j-1];
            if (temp > max) {
              max = temp;
            }
          }
        }
      }
    }
    // S[i][j] - S[i-1][j] - S[i][j-1] + S[i-1][j-1]
    
    System.out.println(max);
    
  }

}