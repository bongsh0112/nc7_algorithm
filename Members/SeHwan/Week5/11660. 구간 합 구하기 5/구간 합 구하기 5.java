import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();
    
    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);
    int[][] arr = new int[N + 1][N + 1];
    
    for (int i = 1; i <= N; i++) {
      str = bufferedReader.readLine().split(" ");
      for (int j = 1; j <= N; j++) {
        arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + Integer.parseInt(str[j - 1]);
      }
    }
    
    for (int i = 0; i < M; i++) {
      str = bufferedReader.readLine().split(" ");
      int r1 = Integer.parseInt(str[0]); int c1 = Integer.parseInt(str[1]);
      int r2 = Integer.parseInt(str[2]); int c2 = Integer.parseInt(str[3]);
      int result = arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r1-1][c1-1];
      stringBuffer.append(result + "\n");
    }
    
    System.out.println(stringBuffer.toString());
    
  }
  
}