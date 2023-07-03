import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer();
    
    String[] str = bufferedReader.readLine().split(" ");
    int N = Integer.parseInt(str[0]); // row
    int M = Integer.parseInt(str[1]); // col
    
    int[][] arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      str = bufferedReader.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }
    
    int K = Integer.parseInt(bufferedReader.readLine());
    
    for (int i = 0; i < K; i++) {
      int sum = 0;
      str = bufferedReader.readLine().split(" ");
      int r1 = Integer.parseInt(str[0]) - 1; int r2 = Integer.parseInt(str[2]) - 1;
      int c1 = Integer.parseInt(str[1]) - 1; int c2 = Integer.parseInt(str[3]) - 1;
      for (int j = r1; j <= r2; j++) {
        for (int k = c1; k <= c2; k++) {
          sum += arr[j][k];
        }
      }
      stringBuffer.append(sum + "\n");
    }
    
    System.out.println(stringBuffer.toString());
    
  }
  
}